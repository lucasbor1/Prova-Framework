package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "fornecedores") 
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "O nome do fornecedor deve ser informado.")
    @Length(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String nome;

    @Column(nullable = false, length = 15)
    @NotEmpty(message = "O contato deve ser informado.")
    @Length(min = 8, max = 15, message = "O contato deve ter entre 8 e 15 caracteres.")
    private String contato;

    @Column(nullable = false, length = 50)
    @NotEmpty(message = "A cidade do fornecedor deve ser informada.")
    @Length(min = 3, max = 50, message = "A cidade deve ter entre 3 e 50 caracteres.")
    private String cidade;

    @Column(nullable = false, length = 18, unique = true)
    @NotEmpty(message = "O CNPJ deve ser informado.") 
    private String cnpj;

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
