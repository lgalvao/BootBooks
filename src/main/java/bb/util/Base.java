package bb.util;

import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
public class Base implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
