package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuarios") 
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50) 
    @NotEmpty(message = "O nome deve ser informado.")
    @Length(min = 3, max = 50, message = "O usuario deve ter entre 3 e 50 caracteres.")
    private String usuario;

    @Column(nullable = false, length = 50) 
    @NotEmpty(message = "A senha deve ser informado.")
    @Length(min = 3, max = 50, message = "A senha deve ter entre 3 e 50 caracteres.")
    private String senha;

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
