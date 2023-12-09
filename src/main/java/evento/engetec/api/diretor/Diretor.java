package evento.engetec.api.diretor;

import evento.engetec.api.eventos.Evento;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    // Relacionamento com Evento
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Outros campos e métodos conforme necessário
}
