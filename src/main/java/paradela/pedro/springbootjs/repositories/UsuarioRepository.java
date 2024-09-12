package paradela.pedro.springbootjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paradela.pedro.springbootjs.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Iterable<Usuario> findByNomeOrEmailContainsIgnoreCase(String nome, String email);
}