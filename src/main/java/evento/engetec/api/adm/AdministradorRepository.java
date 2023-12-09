package evento.engetec.api.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    // Métodos adicionais de consulta, se necessário
}
