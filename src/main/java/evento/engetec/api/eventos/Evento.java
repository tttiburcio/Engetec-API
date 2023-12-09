package evento.engetec.api.eventos;

import evento.engetec.api.diretor.Diretor;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Date dataInicio;
    private Date dataFim;
    private String local;
    private String tema;
    private String descricao;

    // Relacionamento com Diretores
    @OneToMany(mappedBy = "evento")
    private List<Diretor> diretores;

    // Outros campos e métodos conforme necessário
}
