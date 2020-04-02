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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Log
public class Importador {
    private final RepoAutor repoAutor;
    private final RepoAvaliacao repoAvaliacao;
    private final RepoLivro repoLivro;
    private final RepoEdicao repoEdicao;
    private final RepoSerie repoSerie;
    private final RepoLeitura repoLeitura;
    private final RepoEditora repoEditora;

    @Autowired
    public Importador(RepoAutor repoAutor,
                      RepoAvaliacao repoAvaliacao, RepoEdicao repoEdicao,
                      RepoLivro repoLivro,
                      RepoSerie repoSerie, RepoLeitura repoLeitura, RepoEditora repoEditora) {

        this.repoAutor = repoAutor;
        this.repoAvaliacao = repoAvaliacao;
        this.repoLivro = repoLivro;
        this.repoEdicao = repoEdicao;
        this.repoSerie = repoSerie;
        this.repoLeitura = repoLeitura;
        this.repoEditora = repoEditora;
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

    private void limparTabelas() {
        String script = "truncate table avaliacao restart identity cascade;" +
                "truncate table categoria_categorias_filhas restart identity cascade;" +
                "truncate table estante_edicoes restart identity cascade;" +
                "truncate table estante restart identity cascade;" +
                "truncate table leitura restart identity cascade;" +
                "truncate table edicao restart identity cascade;" +
                "truncate table editora restart identity cascade;" +
                "truncate table idioma restart identity cascade;" +
                "truncate table livro_outros_autores restart identity cascade;" +
                "truncate table livro_tags restart identity cascade;" +
                "truncate table livro restart identity cascade;" +
                "truncate table autor restart identity cascade;" +
                "truncate table categoria restart identity cascade;" +
                "truncate table pais restart identity cascade;" +
                "truncate table regiao restart identity cascade;" +
                "truncate table serie restart identity cascade;" +
                "truncate table tag restart identity cascade;";


    }

    public void importacaoGeral() throws Exception {
        limparTabelas();

        for (CSVRecord linha : lerCsv()) {
            String nomeAutor = linha.get(Campos.Author);
            Autor autor = repoAutor.save(Autor.builder().nome(nomeAutor).build());

            //TODO melhorar nomenclatura pq não é bem título nesse ponto
            String titulo = linha.get(Campos.Title);
            String nomeSerie = "";
            int posicaoSerie = titulo.indexOf("(");
            if (posicaoSerie != -1) {
                nomeSerie = titulo.substring(posicaoSerie + 1, titulo.length() - 1);
                titulo = titulo.substring(0, posicaoSerie).trim();
            }

            Serie serie = null;
            if (!nomeSerie.isEmpty()) {
                serie = repoSerie.save(Serie.builder().nome(nomeSerie).build());
            }

            String anoPublicacaoStr = linha.get(Campos.OriginalPublicationYear).trim().strip();
            Integer anoPublicacao = null;
            if (!anoPublicacaoStr.isEmpty()) {
                anoPublicacao = Integer.parseInt(anoPublicacaoStr);
            }
            Livro livro = Livro.builder()
                    .autorPrincipal(autor)
                    .serie(serie)
                    .titulo(titulo)
                    .anoPublicacao(anoPublicacao)
                    .build();
            livro = repoLivro.save(livro);

            String estrelasAvaliacao = linha.get(Campos.MyRating).trim().strip();
            String textoAvaliacao = linha.get(Campos.MyReview).trim();
            if (!estrelasAvaliacao.isEmpty() && !estrelasAvaliacao.equals("0")) {
                Avaliacao avaliacao = Avaliacao.builder()
                        .texto(textoAvaliacao)
                        .estrelas(Integer.parseInt(estrelasAvaliacao))
                        .livro(livro).build();
                repoAvaliacao.save(avaliacao);
            }

            String isbn13 = linha.get(Campos.ISBN13)
                    .replaceAll("=", "")
                    .replaceAll("\"", "");

            String isbn = linha.get(Campos.ISBN)
                    .replaceAll("=", "")
                    .replaceAll("\"", "");

            String paginasStr = linha.get(Campos.Pages).trim();
            Integer paginas = null;
            if (!paginasStr.isEmpty()) {
                paginas = Integer.parseInt(paginasStr);
            }

            Edicao edicao = Edicao.builder()
                    .isbn(isbn)
                    .isbn13(isbn13)
                    .livro(livro)
                    .titulo(titulo)
                    .paginas(paginas)
                    .build();
            repoEdicao.save(edicao);

            String nomeEditora = linha.get(Campos.Publisher);
            if (!nomeEditora.isEmpty()) {
                Editora editora = repoEditora.findByNome(nomeEditora);
                if (editora == null) {
                    editora = Editora.builder().nome(nomeEditora).build();
                    repoEditora.save(editora);
                } else edicao.setEditora(editora);

            }

            String dataLeituraStr = linha.get(Campos.DateRead).trim();
            if (!dataLeituraStr.isEmpty()) {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate dataLeitura = LocalDate.parse(dataLeituraStr, formatador);
                Leitura leitura = Leitura.builder().edicao(edicao).termino(dataLeitura).build();
                repoLeitura.save(leitura);
            }
        }
    }

    private Iterable<CSVRecord> lerCsv() throws IOException {
        Reader in = new FileReader("/Users/leonardo/projetos/BootBooks/livros.csv");
        return CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
    }
}
