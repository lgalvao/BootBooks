package books.dominio;

import books.util.Base;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Regiao extends Base {
    String nome;
}
