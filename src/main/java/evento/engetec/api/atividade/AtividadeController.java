package evento.engetec.api.atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public ResponseEntity<List<Atividade>> getAllAtividades() {
        List<Atividade> atividades = atividadeService.getAllAtividades();
        return new ResponseEntity<>(atividades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> getAtividadeById(@PathVariable Long id) {
        Atividade atividade = atividadeService.getAtividadeById(id);
        return new ResponseEntity<>(atividade, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Atividade> createAtividade(@RequestBody Atividade atividade) {
        Atividade createdAtividade = atividadeService.createAtividade(atividade);
        return new ResponseEntity<>(createdAtividade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atividade> updateAtividade(@PathVariable Long id, @RequestBody Atividade atividade) {
        Atividade updatedAtividade = atividadeService.updateAtividade(id, atividade);
        return new ResponseEntity<>(updatedAtividade, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtividade(@PathVariable Long id) {
        atividadeService.deleteAtividade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
