package evento.engetec.api.diretor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @GetMapping
    public ResponseEntity<List<Diretor>> getAllDiretores() {
        List<Diretor> diretores = diretorService.getAllDiretores();
        return new ResponseEntity<>(diretores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretor> getDiretorById(@PathVariable Long id) {
        Diretor diretor = diretorService.getDiretorById(id);
        return new ResponseEntity<>(diretor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Diretor> createDiretor(@RequestBody Diretor diretor) {
        Diretor createdDiretor = diretorService.createDiretor(diretor);
        return new ResponseEntity<>(createdDiretor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diretor> updateDiretor(@PathVariable Long id, @RequestBody Diretor diretor) {
        Diretor updatedDiretor = diretorService.updateDiretor(id, diretor);
        return new ResponseEntity<>(updatedDiretor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiretor(@PathVariable Long id) {
        diretorService.deleteDiretor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
