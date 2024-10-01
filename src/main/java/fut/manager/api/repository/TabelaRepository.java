package fut.manager.api.repository;

import fut.manager.api.models.entities.Tabela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TabelaRepository extends JpaRepository<Tabela, Long> {
    List<Tabela> findAllByOrderByPontosDesc();
}
