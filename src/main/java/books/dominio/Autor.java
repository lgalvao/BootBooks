package books.dominio;

import books.util.Base;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Autor extends Base {
    String nome;
    String biografia;

    @ManyToOne
    Pais pais;
}
