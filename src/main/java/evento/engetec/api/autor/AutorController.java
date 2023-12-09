package evento.engetec.api.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        List<Autor> autores = autorService.getAllAutores();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        Autor autor = autorService.getAutorById(id);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        Autor createdAutor = autorService.createAutor(autor);
        return new ResponseEntity<>(createdAutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        Autor updatedAutor = autorService.updateAutor(id, autor);
        return new ResponseEntity<>(updatedAutor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
