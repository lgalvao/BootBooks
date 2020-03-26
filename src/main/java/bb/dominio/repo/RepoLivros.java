package bb.dominio.repo;

import bb.dominio.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoLivros extends JpaRepository<Livro, Long> {
}
