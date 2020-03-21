package books.dominio;

import books.util.Base;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Entity
public class Livro extends Base {
    String titulo;

    @OneToMany
    List<Autor> autores;

    @OneToOne
    Categoria categoria;

    @OneToMany
    List<Tag> tags;
}
