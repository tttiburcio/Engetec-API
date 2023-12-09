package evento.engetec.api.autor;

import evento.engetec.api.artigo.Artigo;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    // Relacionamento com Artigos
    @OneToMany(mappedBy = "autorResponsavel")
    private List<Artigo> artigos;

    // Outros campos e métodos conforme necessário
}
