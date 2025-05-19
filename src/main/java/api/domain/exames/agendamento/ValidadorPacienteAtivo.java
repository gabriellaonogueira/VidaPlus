package api.domain.exames.agendamento;

import api.domain.ValidacaoException;
import api.domain.exames.DadosAgendamentoExame;
import api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validadorExamePacienteAtivo")
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeExame {

    @Autowired
    private PacienteRepository repository;

    public void validar (DadosAgendamentoExame dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("O exame não pode ser agendada para este paciente.");
        }
    }
}
