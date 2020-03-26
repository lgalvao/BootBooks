package bb.dominio.repo;

import bb.dominio.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAvaliacao extends JpaRepository<Avaliacao, Long> {
}
