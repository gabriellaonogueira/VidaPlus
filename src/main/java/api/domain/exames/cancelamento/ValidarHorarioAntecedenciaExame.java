package api.domain.exames.cancelamento;

import api.domain.ValidacaoException;
import api.domain.exames.DadosCancelamentoExame;
import api.domain.exames.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamentoExame")
public class ValidarHorarioAntecedenciaExame implements ValidadorCancelamentoDeExame{
    @Autowired
    private ExameRepository repository;

    @Override
    public void validar(DadosCancelamentoExame dados) {
        var exame = repository.getReferenceById(dados.idExame());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, exame.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Exame somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
