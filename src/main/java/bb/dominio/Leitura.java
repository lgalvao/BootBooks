package bb.dominio;

import bb.util.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Leitura extends Base {
    private static final long serialVersionUID = 1L;

    LocalDate inicio;
    LocalDate termino;

    @ManyToOne
    Edicao edicao;
}
