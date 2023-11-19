package com.example.sa.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String accountType;
    private String senha;
    
    public String getEmail(){
        return this.email;
    }
    public String getSenha(){
        return this.senha;
    }
}
