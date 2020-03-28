package bb.dominio;

import bb.util.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Livro extends Base {
    private static final long serialVersionUID = 1L;

    String titulo;
    String subtitulo;
    Integer anoPublicacao;

    @ManyToOne
    Autor autorPrincipal;

    @OneToMany
    List<Autor> outrosAutores;

    @ManyToOne
    Categoria categoria;

    @ManyToOne
    Serie serie;

    @OneToMany
    List<Tag> tags;
}
