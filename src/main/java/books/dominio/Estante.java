package books.dominio;

import books.util.Base;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Estante extends Base {
    String nome;

    @OneToMany
    List<Edicao> edicoes;
}
