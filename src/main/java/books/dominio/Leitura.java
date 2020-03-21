package books.dominio;

import books.util.Base;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class Leitura extends Base {
    LocalDate inicio;
    LocalDate termino;

    @ManyToOne
    Edicao edicao;
}
