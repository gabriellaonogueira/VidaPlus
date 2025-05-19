package api.domain.exames.agendamento;

import api.domain.ValidacaoException;
import api.domain.exames.DadosAgendamentoExame;
import api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validadorExameMedicoAtivo")
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeExame {

    @Autowired
    private MedicoRepository repository;

    public void validar (DadosAgendamentoExame dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Exame não pode ser agendada com esse médico.");
        }
    }
}
