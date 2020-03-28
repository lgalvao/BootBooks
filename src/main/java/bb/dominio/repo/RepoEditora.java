package bb.dominio.repo;

import bb.dominio.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEditora extends JpaRepository<Editora, Long> {
    Editora findByNome(String nomeEditora);
}
