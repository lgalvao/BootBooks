package bb.util;

import bb.dominio.*;
import bb.dominio.repo.*;
import lombok.extern.java.Log;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
@Log
public class Importador {
    private final RepoAutor repoAutor;
    private final RepoAvaliacao repoAvaliacao;
    private final RepoLivro repoLivro;
    private final RepoEdicao repoEdicao;
    private final RepoSerie repoSerie;

    @Autowired
    public Importador(RepoAutor repoAutor,
                      RepoAvaliacao repoAvaliacao, RepoEdicao repoEdicao,
                      RepoLivro repoLivro,
                      RepoSerie repoSerie) {

        this.repoAutor = repoAutor;
        this.repoAvaliacao = repoAvaliacao;
        this.repoLivro = repoLivro;
        this.repoEdicao = repoEdicao;
        this.repoSerie = repoSerie;
    }

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
        for (CSVRecord linha : lerCsv()) {
            String nomeAutor = linha.get(Campos.Author);
            Autor autor = repoAutor.save(Autor.builder().nome(nomeAutor).build());

            String titulo = linha.get(Campos.Title);
            String nomeSerie = "";
            int posicaoSerie = titulo.indexOf("(");
            if (posicaoSerie != -1) {
                nomeSerie = titulo.substring(posicaoSerie + 1, titulo.length() - 1);
                titulo = titulo.substring(0, posicaoSerie).trim();
            }
            Serie serie = repoSerie.save(Serie.builder().nome(nomeSerie).build());

            String isbn13 = linha.get(Campos.ISBN13);
            Livro livro = Livro.builder()
                    .autorPrincipal(autor)
                    .serie(serie)
                    .titulo(titulo)
                    .build();
            livro = repoLivro.save(livro);

            String estrelasAvaliacao = linha.get(Campos.MyRating);
            String textoAvaliacao = linha.get(Campos.MyReview);
            if (!estrelasAvaliacao.isEmpty()) {
                Avaliacao avaliacao = Avaliacao.builder()
                        .texto(textoAvaliacao)
                        .estrelas(Integer.parseInt(estrelasAvaliacao))
                        .livro(livro).build();
                repoAvaliacao.save(avaliacao);
            }

            Edicao edicao = Edicao.builder()
                    .isbn(isbn13)
                    .livro(livro)
                    .titulo(titulo)
                    .build();
            repoEdicao.save(edicao);
        }
    }

    private Iterable<CSVRecord> lerCsv() throws IOException {
        Reader in = new FileReader("/Users/leonardo/projetos/BootBooks/livros.csv");
        return CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
    }
}
