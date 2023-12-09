package evento.engetec.api.atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> getAllAtividades() {
        return atividadeRepository.findAll();
    }

    public Atividade getAtividadeById(Long id) {
        Optional<Atividade> atividadeOptional = atividadeRepository.findById(id);
        return atividadeOptional.orElse(null);
    }

    public Atividade createAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public Atividade updateAtividade(Long id, Atividade atividade) {
        if (atividadeRepository.existsById(id)) {
            atividade.setId(id);
            return atividadeRepository.save(atividade);
        }
        return null; // Pode considerar lançar uma exceção
    }

    public void deleteAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }
}

