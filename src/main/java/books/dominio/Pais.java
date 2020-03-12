package books.dominio;

import books.util.Base;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class Pais extends Base {
    String nome;
}
