package bb.dominio;

import bb.util.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pais extends Base {
    private static final long serialVersionUID = 1L;

    String nome;

    @ManyToOne
    Regiao regiao;
}
