package paradela.pedro.springbootjs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import paradela.pedro.springbootjs.models.Tarefa;
import paradela.pedro.springbootjs.repositories.TarefaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/")
    public Iterable<Tarefa> getTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{page}")
    public Iterable<Tarefa> getTarefas(@PathVariable @DefaultValue("0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return tarefaRepository.findAll(pageable);
    }

    @PutMapping("/{id}")
    public Tarefa edit(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Tarefa save(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}
