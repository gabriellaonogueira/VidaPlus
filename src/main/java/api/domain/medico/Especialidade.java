package api.domain.medico;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Especialidade {

    ORTOPEDIA,
    CARDIOLOGIA,
    GINECOLOGIA,
    DERMATOLOGIA;

    @JsonCreator
    public static Especialidade fromString(String value) {
        return Especialidade.valueOf(value.toUpperCase());
    }
}
