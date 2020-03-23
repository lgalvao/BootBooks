package books.dominio.repo;

import books.dominio.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAutores extends JpaRepository<Autor, Long> {
}
