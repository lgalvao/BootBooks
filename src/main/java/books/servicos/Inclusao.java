package books.servicos;

import books.dominio.Edicao;
import books.dominio.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Inclusao {
    @Autowired
    RepoLivros repoLivros;

    public void incluirEdicao(long idLivro, String isbn, String titulo) {
        Edicao e = new Edicao();
        Optional<Livro> livroOpt = repoLivros.findById(idLivro);
        if (livroOpt.isPresent()) {
            e.setLivro(livroOpt.get());
        }
        e.setIsbn(isbn);
        e.setTitulo(titulo);
    }
}
