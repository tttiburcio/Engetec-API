package evento.engetec.api.diretor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    public List<Diretor> getAllDiretores() {
        return diretorRepository.findAll();
    }

    public Diretor getDiretorById(Long id) {
        Optional<Diretor> diretorOptional = diretorRepository.findById(id);
        return diretorOptional.orElse(null);
    }

    public Diretor createDiretor(Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    public Diretor updateDiretor(Long id, Diretor diretor) {
        if (diretorRepository.existsById(id)) {
            diretor.setId(id);
            return diretorRepository.save(diretor);
        }
        return null; // Pode considerar lançar uma exceção
    }

    public void deleteDiretor(Long id) {
        diretorRepository.deleteById(id);
    }
}
