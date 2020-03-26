package bb.dominio.repo;

import bb.dominio.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEdicao extends JpaRepository<Edicao, Long> {
}
