package bb.dominio;

import bb.util.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Livro extends Base {
    private static final long serialVersionUID = 1L;
    String titulo;
    String subtitulo;

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
