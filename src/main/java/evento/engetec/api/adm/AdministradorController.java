package evento.engetec.api.adm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public ResponseEntity<List<Administrador>> getAllAdministradores() {
        List<Administrador> administradores = administradorService.getAllAdministradores();
        return new ResponseEntity<>(administradores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Long id) {
        Administrador administrador = administradorService.getAdministradorById(id);
        return new ResponseEntity<>(administrador, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Administrador> createAdministrador(@RequestBody Administrador administrador) {
        Administrador createdAdministrador = administradorService.createAdministrador(administrador);
        return new ResponseEntity<>(createdAdministrador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> updateAdministrador(@PathVariable Long id, @RequestBody Administrador administrador) {
        Administrador updatedAdministrador = administradorService.updateAdministrador(id, administrador);
        return new ResponseEntity<>(updatedAdministrador, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable Long id) {
        administradorService.deleteAdministrador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
