package api.domain.exames.cancelamento;

import api.domain.exames.DadosCancelamentoExame;

public interface ValidadorCancelamentoDeExame {
    void validar(DadosCancelamentoExame dados);
}
