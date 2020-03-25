package bb.dominio;

import bb.util.Base;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class Pais extends Base {
    String nome;

    @ManyToOne
    Regiao regiao;
}