package api.domain.consulta.validacoes.agendamento;

import api.domain.ValidacaoException;
import api.domain.consulta.DadosAgendamentoConsulta;
import api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("validadorConsultaMedicoAtivo")
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar (DadosAgendamentoConsulta dados) {
        //opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com esse médico.");
        }
    }
}
