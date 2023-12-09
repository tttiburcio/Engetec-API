package evento.engetec.api.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventos() {
        List<Evento> eventos = eventoService.getAllEventos();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        Evento createdEvento = eventoService.createEvento(evento);
        return new ResponseEntity<>(createdEvento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
        Evento updatedEvento = eventoService.updateEvento(id, evento);
        return new ResponseEntity<>(updatedEvento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
