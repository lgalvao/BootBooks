package bb.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ImportadorTest {
    @Autowired
    Importador importador;

    @Test
    void importar() throws IOException {
        importador.listarConteudoBruto();
    }

    @Test
    void lerComEnum() throws IOException {
        importador.lerComEnum();
    }

    @Test
    void importacaoGeral() throws Exception {
        importador.importacaoGeral();
    }
}