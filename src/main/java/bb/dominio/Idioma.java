package bb.dominio;

import bb.util.Base;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class Idioma extends Base {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String nome;
}
