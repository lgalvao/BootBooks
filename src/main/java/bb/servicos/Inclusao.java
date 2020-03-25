package bb.servicos;

import bb.dominio.Autor;
import bb.dominio.Edicao;
import bb.dominio.Livro;
import bb.dominio.repo.RepoAutores;
import bb.dominio.repo.RepoEdicoes;
import bb.dominio.repo.RepoLivros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Inclusao {
    final RepoLivros repoLivros;
    final RepoEdicoes repoEdicoes;
    final RepoAutores repoAutores;

    @Autowired
    public Inclusao(RepoAutores repoAutores, RepoEdicoes repoEdicoes, RepoLivros repoLivros) {
        this.repoLivros = repoLivros;
        this.repoAutores = repoAutores;
        this.repoEdicoes = repoEdicoes;
    }

    public Edicao incluirEdicao(Livro livro, String isbn, String titulo) {
        Edicao edicao = new Edicao();
        edicao.setLivro(livro);
        edicao.setIsbn(isbn);
        edicao.setTitulo(titulo);

        return repoEdicoes.save(edicao);
    }

    public Autor incluirAutor(String nome) {
        Autor autor = new Autor();
        autor.setNome(nome);

        return repoAutores.save(autor);
    }

    public Livro incluirLivro(String titulo, Autor autorPrincipal) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutorPrincipal(autorPrincipal);

        return repoLivros.save(livro);
    }
}
