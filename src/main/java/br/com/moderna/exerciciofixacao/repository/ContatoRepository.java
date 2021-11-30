package br.com.moderna.exerciciofixacao.repository;

import br.com.moderna.exerciciofixacao.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Long> {
}
