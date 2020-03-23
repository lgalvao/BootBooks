package books.dominio.repo;

import books.dominio.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEdicoes extends JpaRepository<Edicao, Long> {
}
