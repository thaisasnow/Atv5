package br.com.tudocelular.gestaolojacelular.app.controller;

import br.com.tudocelular.gestaolojacelular.domain.model.Celular;
import br.com.tudocelular.gestaolojacelular.service.CelularService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "rh")
@Tag(name = "RH Controller", description = "Controladora que gere o cadastro de massas")
public class MassaController {
    private final MassaService massaService;

    public MassaController(MassaService celularService){
            this.massaService = massaService;
    }

    @PostMapping(value = "/massa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra uma massa", responses = {@ApiResponse(description = "Sucesso ao cadastrar", responseCode = "201", content = @Content)})
    ResponseEntity<Massa> save(@RequestBody Massa massa) {
        return new ResponseEntity<>(massaService.save(massa), CREATED);
    }

    @GetMapping(value = "/massa", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lista de massas", responses = {@ApiResponse(description = "Sucesso ao listar as massas", responseCode = "200", content = @Content)})
    ResponseEntity<List<Massa>> findAll() {
        return new ResponseEntity<>(massaService.findAll(), OK);
    }

    @GetMapping(value = "/massa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Localiza um cadastro de massa por ID", responses = {@ApiResponse(description = "Sucesso ao consultar o cadastro", responseCode = "200", content = @Content)})
    ResponseEntity<Massa> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(massaService.findById(id), OK);
    }

    @PutMapping(value = "/massa", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualiza um massa", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "201", content = @Content)})
    ResponseEntity<?> update(@RequestBody Massa massa) {
        massaService.save(massa);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(value = "/massa/{id}")
    @Operation(summary = "Exclui um cadastro de massa pelo ID", responses = {@ApiResponse(description = "Sucesso ao apagar o cadastro", responseCode = "204")})
    ResponseEntity<?> deleteById(@PathVariable UUID id) {
        massaService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
    @PatchMapping(value = "/celular/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar preço do celular", responses = {@ApiResponse(description = "Preço da massa", responseCode = "201", content = @Content)})
    ResponseEntity<?> updatePreco(@PathVariable UUID id, @RequestBody float preco) {
        massaService.update(id, preco);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
