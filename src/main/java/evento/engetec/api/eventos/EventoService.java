package evento.engetec.api.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public Evento getEventoById(Long id) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);
        return eventoOptional.orElse(null);
    }

    public Evento createEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento updateEvento(Long id, Evento evento) {
        if (eventoRepository.existsById(id)) {
            evento.setId(id);
            return eventoRepository.save(evento);
        }
        return null; // Pode considerar lançar uma exceção
    }

    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
