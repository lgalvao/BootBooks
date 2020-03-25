package bb.dominio;

import bb.util.Base;
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

    LocalDate dataPublicacao;
    int paginas;
}
