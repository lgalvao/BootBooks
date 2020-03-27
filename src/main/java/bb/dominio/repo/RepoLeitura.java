package bb.dominio.repo;

import bb.dominio.Leitura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoLeitura extends JpaRepository<Leitura, Long> {
}
