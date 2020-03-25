package books.dominio;

import books.util.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Estante extends Base {
    String nome;

    @OneToMany
    List<Edicao> edicoes;
}