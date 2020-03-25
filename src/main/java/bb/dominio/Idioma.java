package bb.dominio;

import bb.util.Base;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class Idioma extends Base {
    String nome;
}
