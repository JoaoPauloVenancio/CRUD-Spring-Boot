package br.com.moderna.exerciciofixacao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table (name = "contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(nullable = false, length = 4)
    private String ddd;
    @Column(nullable = false, length = 50)
    private String email;
}
