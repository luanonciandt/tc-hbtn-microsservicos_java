package com.example.jpah2demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente implements Serializable {

    private static final long serialUIDVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    public Cliente() {
        this.telefones = new ArrayList<>();
        this.enderecos = new ArrayList<>();
    }

    public Cliente(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefones = new ArrayList<>();
        this.enderecos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return getIdade() == cliente.getIdade() && Objects.equals(getNome(), cliente.getNome()) && Objects.equals(getEmail(), cliente.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getIdade(), getEmail());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                '}';
    }

}
