package evento.engetec.api.artigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @GetMapping
    public ResponseEntity<List<Artigo>> getAllArtigos() {
        List<Artigo> artigos = artigoService.getAllArtigos();
        return new ResponseEntity<>(artigos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artigo> getArtigoById(@PathVariable Long id) {
        Artigo artigo = artigoService.getArtigoById(id);
        return new ResponseEntity<>(artigo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artigo> createArtigo(@RequestBody Artigo artigo) {
        Artigo createdArtigo = artigoService.createArtigo(artigo);
        return new ResponseEntity<>(createdArtigo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artigo> updateArtigo(@PathVariable Long id, @RequestBody Artigo artigo) {
        Artigo updatedArtigo = artigoService.updateArtigo(id, artigo);
        return new ResponseEntity<>(updatedArtigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtigo(@PathVariable Long id) {
        artigoService.deleteArtigo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
