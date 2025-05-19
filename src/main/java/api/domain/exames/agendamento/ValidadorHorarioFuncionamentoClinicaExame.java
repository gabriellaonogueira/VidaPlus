package api.domain.exames.agendamento;

import api.domain.ValidacaoException;
import api.domain.exames.DadosAgendamentoExame;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinicaExame implements ValidadorAgendamentoDeExame {

    public void validar(DadosAgendamentoExame dados) {
        var dataExame = dados.data();

        var domingo = dataExame.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataExame.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataExame.getHour() > 18;
        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Exame fora do horário permitido");
        }
    }
}
