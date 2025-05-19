package api.domain.consulta.validacoes.agendamento;

import api.domain.ValidacaoException;
import api.domain.consulta.DadosAgendamentoConsulta;
import api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validadorConsultaPacienteAtivo")
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar (DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada para este paciente.");
        }
    }
}
