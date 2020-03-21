package books.dominio;

import books.util.Base;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Blob;

@Entity
@Data
@NoArgsConstructor
public class Edicao extends Base {
    private String isbn;
    private String titulo;

    @ManyToOne
    private Livro livro;

    @OneToOne
    private Idioma idioma;

    @OneToOne
    private Editora editora;

    @Lob
    private Blob capa;

    private int paginas;
}
