package api.domain.exames;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MotivoCancelamento {
    PACIENTE_DESISTIU,
    MEDICO_CANCELOU,
    OUTROS;

    @JsonCreator
    public static MotivoCancelamento fromString(String value) {
        return MotivoCancelamento.valueOf(value.toUpperCase());
    }
}
