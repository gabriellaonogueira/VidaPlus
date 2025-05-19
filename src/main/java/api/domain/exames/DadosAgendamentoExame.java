package api.domain.exames;

import api.domain.medico.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoExame(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,

        @Enumerated
        Especialidade especialidade
) {}

