package bb.dominio;

import bb.util.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Serie extends Base {
    private static final long serialVersionUID = 1L;

    String nome;
}