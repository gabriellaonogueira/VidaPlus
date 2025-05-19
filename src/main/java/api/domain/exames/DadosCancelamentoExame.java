package api.domain.exames;

import api.domain.consulta.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoExame(
        @NotNull
        Long idExame,

        @NotNull
        MotivoCancelamento motivo) {
}
