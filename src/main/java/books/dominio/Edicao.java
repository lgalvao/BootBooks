package books.dominio;

import books.util.Base;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Blob;

@Entity
@Getter
public class Edicao extends Base {
    String isbn;
    String titulo;

    @ManyToOne
    Livro livro;

    @OneToOne
    Idioma idioma;

    @OneToOne
    Editora editora;

    @Lob
    Blob capa;

    int paginas;
}
