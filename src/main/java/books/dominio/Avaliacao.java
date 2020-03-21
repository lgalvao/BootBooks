package books.dominio;

import books.util.Base;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class Avaliacao extends Base {
    @ManyToOne
    Livro livro;

    LocalDate data;
    int estrelas;
    String texto;
}
