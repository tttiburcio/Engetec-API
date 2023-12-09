package evento.engetec.api.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(Long id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        return autorOptional.orElse(null);
    }

    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor updateAutor(Long id, Autor autor) {
        if (autorRepository.existsById(id)) {
            autor.setId(id);
            return autorRepository.save(autor);
        }
        return null; // Pode considerar lançar uma exceção
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
