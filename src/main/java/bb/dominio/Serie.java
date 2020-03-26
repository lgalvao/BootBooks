package bb.dominio;

import bb.util.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Serie extends Base {
    private static final long serialVersionUID = 1L;

    String nome;
}