package evento.engetec.api.diretor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    // Métodos adicionais de consulta, se necessário
}
