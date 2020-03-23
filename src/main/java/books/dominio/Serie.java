package books.dominio;

import books.util.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Serie extends Base {
    private String nome;
}