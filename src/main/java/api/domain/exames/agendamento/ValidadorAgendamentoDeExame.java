package api.domain.exames.agendamento;

import api.domain.exames.DadosAgendamentoExame;

public interface ValidadorAgendamentoDeExame {
    void validar (DadosAgendamentoExame dados);
}
