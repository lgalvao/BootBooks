package books.dominio;

import books.util.Base;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
public class Categoria extends Base {
    String nome;

    @ManyToOne
    Categoria categoriaMae;

    @OneToMany
    List<Categoria> categoriasFilhas;
}
