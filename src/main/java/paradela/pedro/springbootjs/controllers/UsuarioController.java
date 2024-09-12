package paradela.pedro.springbootjs.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import paradela.pedro.springbootjs.models.Usuario;
import paradela.pedro.springbootjs.repositories.UsuarioRepository;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
    public Usuario salvarUsuario(@Valid @RequestBody Usuario aluno) {
        usuarioRepository.save(aluno);
        return aluno;
    }

    @GetMapping(path = "/{texto}")
    public Iterable<Usuario> getUsuariosByNome(@PathVariable String texto) {
        return usuarioRepository.findByNomeOrEmailContainsIgnoreCase(texto, texto);
    }

    @GetMapping
    public Iterable<Usuario> getAlunos() {
        return getUsuarioPage(0, 5);
    }

    @GetMapping(path = "/{numero}/{qtde}")
    public Iterable<Usuario> getUsuarioPage(@PathVariable Integer numero, @PathVariable Integer qtde) {
        Pageable pageable = PageRequest.of(numero, qtde > 5 ? 5 : qtde);
        return usuarioRepository.findAll(pageable);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
    }


}
