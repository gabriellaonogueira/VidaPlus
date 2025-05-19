package api.controller;

import api.domain.exames.AgendaDeExames;
import api.domain.exames.DadosAgendamentoExame;
import api.domain.exames.DadosCancelamentoExame;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("exames")
@SecurityRequirement(name = "bearer-key")
public class ExameController {

    @Autowired
    private AgendaDeExames agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DadosAgendamentoExame dados) {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> cancelar(@RequestBody @Valid DadosCancelamentoExame dados) {
        agenda.cancelar(dados);
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .body("Exame cancelado com sucesso!");
    }


}



