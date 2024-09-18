package paradela.pedro.springbootjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paradela.pedro.springbootjs.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}