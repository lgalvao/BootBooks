package bb.dominio;

import bb.util.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Autor extends Base {
    String nome;
    String biografia;

    @ManyToOne
    Pais pais;
}
