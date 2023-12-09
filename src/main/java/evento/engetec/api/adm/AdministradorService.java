package evento.engetec.api.adm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> getAllAdministradores() {
        return administradorRepository.findAll();
    }

    public Administrador getAdministradorById(Long id) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);
        return administradorOptional.orElse(null);
    }

    public Administrador createAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Administrador updateAdministrador(Long id, Administrador administrador) {
        if (administradorRepository.existsById(id)) {
            administrador.setId(id);
            return administradorRepository.save(administrador);
        }
        return null; // Pode considerar lançar uma exceção
    }

    public void deleteAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
}
