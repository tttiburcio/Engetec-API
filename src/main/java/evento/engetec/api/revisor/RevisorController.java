package evento.engetec.api.revisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revisores")
public class RevisorController {

    @Autowired
    private RevisorService revisorService;

    @GetMapping
    public ResponseEntity<List<Revisor>> getAllRevisores() {
        List<Revisor> revisores = revisorService.getAllRevisores();
        return new ResponseEntity<>(revisores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revisor> getRevisorById(@PathVariable Long id) {
        Revisor revisor = revisorService.getRevisorById(id);
        return new ResponseEntity<>(revisor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Revisor> createRevisor(@RequestBody Revisor revisor) {
        Revisor createdRevisor = revisorService.createRevisor(revisor);
        return new ResponseEntity<>(createdRevisor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revisor> updateRevisor(@PathVariable Long id, @RequestBody Revisor revisor) {
        Revisor updatedRevisor = revisorService.updateRevisor(id, revisor);
        return new ResponseEntity<>(updatedRevisor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRevisor(@PathVariable Long id) {
        revisorService.deleteRevisor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
