package evento.engetec.api.revisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevisorService {

    @Autowired
    private RevisorRepository revisorRepository;

    public List<Revisor> getAllRevisores() {
        return revisorRepository.findAll();
    }

    public Revisor getRevisorById(Long id) {
        Optional<Revisor> revisorOptional = revisorRepository.findById(id);
        return revisorOptional.orElse(null);
    }

    public Revisor createRevisor(Revisor revisor) {
        return revisorRepository.save(revisor);
    }

    public Revisor updateRevisor(Long id, Revisor revisor) {
        if (revisorRepository.existsById(id)) {
            revisor.setId(id);
            return revisorRepository.save(revisor);
        }
        return null; // Pode considerar lançar uma exceção
    }

    public void deleteRevisor(Long id) {
        revisorRepository.deleteById(id);
    }
}
