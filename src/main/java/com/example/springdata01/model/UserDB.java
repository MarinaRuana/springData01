package com.example.springdata01.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity // Cria uma tabela no Banco de dados
@Table(name = "tb_user") // Seta o nome da tabela no Banco de dados
public class UserDB {
    @Id // Indica que é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica geração sequencial do id (1, 2, 3..., n)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(length = 80, nullable = false, unique = true)
    private String email;
}
