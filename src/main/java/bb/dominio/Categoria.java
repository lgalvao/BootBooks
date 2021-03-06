package bb.dominio;

import bb.util.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Categoria extends Base {
    private static final long serialVersionUID = 1L;

    String nome;

    @ManyToOne
    Categoria categoriaMae;

    @OneToMany
    List<Categoria> categoriasFilhas;
}
