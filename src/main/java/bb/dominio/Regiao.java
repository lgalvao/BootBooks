package bb.dominio;

import bb.util.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Regiao extends Base {
    private static final long serialVersionUID = 1L;

    String nome;

    @OneToMany(mappedBy = "regiao")
    List<Pais> paises;
}
