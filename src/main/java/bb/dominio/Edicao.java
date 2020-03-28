package bb.dominio;

import bb.util.Base;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Edicao extends Base {
    private static final long serialVersionUID = 1L;

    String isbn;
    String isbn13;
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
    Integer paginas;
}
