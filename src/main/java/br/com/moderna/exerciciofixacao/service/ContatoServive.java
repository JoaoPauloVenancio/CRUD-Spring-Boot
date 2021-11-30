package br.com.moderna.exerciciofixacao.service;

import br.com.moderna.exerciciofixacao.domain.Contato;
import br.com.moderna.exerciciofixacao.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoServive {

    private ContatoRepository contatoRepository;

    public ContatoServive(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public List<Contato> listar() {
        return contatoRepository.findAll();
    }

    public Contato cadastrar(Contato contato) {
        contatoRepository.save(contato);
        return contato;
    }

    public Contato buscar(Long id) {
        return contatoRepository.findById(id).get();
    }

    public Contato deletar(Long id, Contato contato) {
        contatoRepository.deleteById(id);
        return contato;
    }
}
