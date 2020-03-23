package books.util;

import books.dominio.Autor;
import books.dominio.Edicao;
import books.dominio.Livro;
import books.servicos.Inclusao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class Importador {
    @Autowired
    Inclusao inclusao;

    public void listarConteudoBruto() throws IOException {
        for (CSVRecord record : lerCsv()) {
            for (var field : record) {
                System.out.println(field);
            }
        }
    }

    public void lerComEnum() throws IOException {
        for (CSVRecord campo : lerCsv()) {
            for (Campos nomeCampo : Campos.values()) {
                System.out.printf("%s -> %s\n", nomeCampo, campo.get(nomeCampo));
            }
        }
    }

    public void importarDadosBasicos() throws Exception {
        for (CSVRecord campo : lerCsv()) {
            String titulo = campo.get(Campos.Title);
            String isbn13 = campo.get(Campos.ISBN13);
            String autorPrincipal = campo.get(Campos.Author);

            String serie = "";
            int posicaoSerie = titulo.indexOf("(");
            if (posicaoSerie != -1) {
                serie = titulo.substring(posicaoSerie + 1, titulo.length() - 1);
                titulo = titulo.substring(0, posicaoSerie).trim();
            }
            System.out.println(titulo + " - " + autorPrincipal + " - " + serie);

            Autor autor = inclusao.incluirAutor(autorPrincipal);
            Livro livro = inclusao.incluirLivro(titulo, autor);
            Edicao edicao = inclusao.incluirEdicao(livro, isbn13, titulo);

            System.out.println(autor);
            System.out.println(livro);
            System.out.println(edicao);
        }
    }

    private Iterable<CSVRecord> lerCsv() throws IOException {
        Reader in = new FileReader("/Users/leonardo/projetos/books/livros.csv");
        return CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
    }
}
