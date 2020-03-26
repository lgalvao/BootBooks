package bb.dominio;

import bb.util.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Estante extends Base {
    private static final long serialVersionUID = 1L;

    String nome;

    @OneToMany
    List<Edicao> edicoes;
}
