package api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MotivoCancelamento {

    PACIENTE_DESISTIU,
    MEDICO_CANCELOU,
    OUTROS;

    @JsonCreator
    public static api.domain.exames.MotivoCancelamento fromString(String value) {
        return api.domain.exames.MotivoCancelamento.valueOf(value.toUpperCase());
    }
}
