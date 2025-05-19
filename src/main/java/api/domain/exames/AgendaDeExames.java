package api.domain.exames;

import api.domain.ValidacaoException;
import api.domain.exames.agendamento.ValidadorAgendamentoDeExame;
import api.domain.exames.cancelamento.ValidadorCancelamentoDeExame;
import api.domain.medico.Medico;
import api.domain.medico.MedicoRepository;
import api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeExames {

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeExame> validadores;

    @Autowired
    private List<ValidadorCancelamentoDeExame> validadoresCancelamento;

    public DadosDetalhamentoExame agendar(DadosAgendamentoExame dados) {
        validarPaciente(dados.idPaciente());
        validarMedicoSeInformado(dados.idMedico());

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.findById(dados.idPaciente())
                .orElseThrow(() -> new ValidacaoException("Paciente não encontrado!"));

        var medico = escolherMedico(dados);
        if (medico == null) {
            throw new ValidacaoException("Não existe médico disponível para a especialidade "
                    + dados.especialidade() + " na data " + dados.data() + "!");
        }

        var exame = new Exame(null, medico, paciente, dados.data(), null);
        exameRepository.save(exame);

        return new DadosDetalhamentoExame(exame);
    }

    public void cancelar(DadosCancelamentoExame dados) {
        validarExame(dados.idExame());

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var exame = exameRepository.findById(dados.idExame())
                .orElseThrow(() -> new ValidacaoException("Exame não encontrado!"));

        exameRepository.save(exame);
    }

    private Medico escolherMedico(DadosAgendamentoExame dados) {
        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido!");
        }

        if (dados.idMedico() != null) {
            return medicoRepository.findById(dados.idMedico())
                    .orElseThrow(() -> new ValidacaoException("Médico não encontrado!"));
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    private void validarPaciente(Long idPaciente) {
        if (idPaciente == null || !pacienteRepository.existsById(idPaciente)) {
            throw new ValidacaoException("Id do paciente informado não existe!");
        }
    }

    private void validarMedicoSeInformado(Long idMedico) {
        if (idMedico != null && !medicoRepository.existsById(idMedico)) {
            throw new ValidacaoException("Id do médico informado não existe!");
        }
    }

    private void validarExame(Long idExame) {
        if (idExame == null || !exameRepository.existsById(idExame)) {
            throw new ValidacaoException("ID do exame informado não existe ou é inválido!");
        }
    }
}
