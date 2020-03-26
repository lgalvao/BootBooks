package bb.dominio;

import bb.util.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao extends Base {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    Livro livro;

    int estrelas;
    String texto;
}