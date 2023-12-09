package evento.engetec.api.artigo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
    // Métodos adicionais de consulta, se necessário
}
