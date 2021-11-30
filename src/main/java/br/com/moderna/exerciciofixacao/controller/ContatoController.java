package br.com.moderna.exerciciofixacao.controller;

import br.com.moderna.exerciciofixacao.domain.Contato;
import br.com.moderna.exerciciofixacao.service.ContatoServive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private ContatoServive contatoServive;

    public ContatoController(ContatoServive contatoServive) {
        this.contatoServive = contatoServive;
    }


    @GetMapping
    public List<Contato> listar() {
        return contatoServive.listar();
    }

    @GetMapping("/{id}")
    public Contato buscar(@PathVariable Long id) {
       return contatoServive.buscar(id);

    }

    @PostMapping
    public Contato cadastrar(@RequestBody Contato contato) {
        contatoServive.cadastrar(contato);
        return contato;
    }

    @DeleteMapping("/{id}")
    public Contato deletar(@PathVariable Long id, Contato contato){
        contatoServive.deletar(id, contato);
        return contato;
    }

}
