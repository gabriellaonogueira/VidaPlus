package api.domain.exames;


import java.time.LocalDateTime;

public record DadosDetalhamentoExame(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public DadosDetalhamentoExame(Exame exame) {
        this(exame.getId(), exame.getMedico().getId(), exame.getPaciente().getId(), exame.getData());
    }
}

