package evento.engetec.api.revisor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisorRepository extends JpaRepository<Revisor, Long> {
    // Métodos adicionais de consulta, se necessário
}
