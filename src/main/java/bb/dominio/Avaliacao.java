package bb.dominio;

import bb.util.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Avaliacao extends Base {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    Livro livro;

    LocalDate data;
    int estrelas;
    String texto;
}