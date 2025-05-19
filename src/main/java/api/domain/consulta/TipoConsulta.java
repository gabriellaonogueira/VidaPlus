package api.domain.consulta;

public enum TipoConsulta {
    Presencial("Presencial"),
    Online("Online");

    private final String valor;

    TipoConsulta(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static TipoConsulta fromString(String text) {
        for (TipoConsulta tipo : TipoConsulta.values()) {
            if (tipo.valor.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + text);
    }
}
