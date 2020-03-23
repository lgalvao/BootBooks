package books.dominio;

import books.util.Base;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Getter
@Setter
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

    private LocalDate dataPublicacao;
    private int paginas;
}
