package bb.dominio.repo;

import bb.dominio.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoSerie extends JpaRepository<Serie, Long> {
}
