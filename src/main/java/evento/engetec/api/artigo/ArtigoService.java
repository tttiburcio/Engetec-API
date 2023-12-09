package evento.engetec.api.artigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    public List<Artigo> getAllArtigos() {
        return artigoRepository.findAll();
    }

    public Artigo getArtigoById(Long id) {
        Optional<Artigo> artigoOptional = artigoRepository.findById(id);
        return artigoOptional.orElse(null);
    }

    public Artigo createArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public Artigo updateArtigo(Long id, Artigo artigo) {
        if (artigoRepository.existsById(id)) {
            artigo.setId(id);
            return artigoRepository.save(artigo);
        }
        return null; // Pode considerar lançar uma exceção
    }

    public void deleteArtigo(Long id) {
        artigoRepository.deleteById(id);
    }
}
