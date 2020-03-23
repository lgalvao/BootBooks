package books.servicos;

import books.dominio.Autor;
import books.dominio.Edicao;
import books.dominio.Livro;
import books.dominio.repo.RepoAutores;
import books.dominio.repo.RepoEdicoes;
import books.dominio.repo.RepoLivros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Inclusao {
    @Autowired
    RepoLivros repoLivros;

    @Autowired
    RepoEdicoes repoEdicoes;

    @Autowired
    RepoAutores repoAutores;

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
