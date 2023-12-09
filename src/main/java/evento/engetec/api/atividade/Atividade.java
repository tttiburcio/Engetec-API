package evento.engetec.api.atividade;

import evento.engetec.api.eventos.Evento;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private Date horarioInicio;
    private Date horarioFim;
    private int capacidade; // Capacidade máxima de participantes

    // Relacionamento com Evento
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Outros campos e métodos conforme necessário
}
