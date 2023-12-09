package evento.engetec.api.artigo;

import evento.engetec.api.autor.Autor;
import evento.engetec.api.revisor.Revisor;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String resumo;
    private String palavrasChave;
    private boolean envolveSeresHumanos;
    private String numeroProcesso;

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "autor_responsavel_id")
    private Autor autorResponsavel;

    @ManyToMany
    @JoinTable(
            name = "artigo_revisor",
            joinColumns = @JoinColumn(name = "artigo_id"),
            inverseJoinColumns = @JoinColumn(name = "revisor_id"))
    private List<Revisor> revisores;

    // Outros campos e métodos conforme necessário
}
