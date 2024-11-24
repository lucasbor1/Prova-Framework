package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "produtos") 
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "O nome do produto deve ser informado.")
    @Length(min = 3, max = 50, message = "O nome do produto deve ter entre 3 e 50 caracteres.")
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "O preço do produto deve ser informado.")
    private Double preco;

    @Column(nullable = false)
    @NotNull(message = "A quantidade de compra deve ser informada.")
    private Integer quantidade;

    @Column(nullable = false)
    @NotEmpty(message = "A categoria do produto deve ser informada.")
    @Length(min = 3, max = 50, message = "A categoria deve ter entre 3 e 50 caracteres.")
    private String categoria;

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
