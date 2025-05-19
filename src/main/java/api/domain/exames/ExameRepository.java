package api.domain.exames;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ExameRepository extends JpaRepository<Exame, Long> {

    boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

}
