package bb.dominio.repo;

import bb.dominio.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAutor extends JpaRepository<Autor, Long> {
}
