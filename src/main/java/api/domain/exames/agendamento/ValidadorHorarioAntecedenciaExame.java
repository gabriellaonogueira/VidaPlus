package api.domain.exames.agendamento;

import api.domain.ValidacaoException;
import api.domain.exames.DadosAgendamentoExame;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaExame implements ValidadorAgendamentoDeExame {

    public void validar(DadosAgendamentoExame dados) {
        var dataExame = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataExame).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("O exame deve ser agendada com antecedência mínima de 30 minutos.");
        }
    }
}