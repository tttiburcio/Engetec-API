package evento.engetec.api.revisor;

import evento.engetec.api.artigo.Artigo;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;
@Data
@Entity
public class Revisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String lattes;
    private String instituicao;
    private String researchId;

    // Relacionamento com Artigos
    @ManyToMany(mappedBy = "revisores")
    private List<Artigo> artigos;

    // Outros campos e métodos conforme necessário
}
