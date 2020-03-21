package books.dominio.repo;

import books.dominio.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEdicao extends JpaRepository<Edicao, Long> {
}
