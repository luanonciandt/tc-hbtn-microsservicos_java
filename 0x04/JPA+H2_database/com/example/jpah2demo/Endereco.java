package com.example.jpah2demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Endereco implements Serializable {

    private static final long serialUIDVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Endereco() {}

    public Endereco(String logradouro, String endereco, String numero, String bairro, String cidade, String estado) {
        this.logradouro = logradouro;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco1 = (Endereco) o;
        return Objects.equals(getLogradouro(), endereco1.getLogradouro()) && Objects.equals(getEndereco(), endereco1.getEndereco()) && Objects.equals(getNumero(), endereco1.getNumero()) && Objects.equals(getBairro(), endereco1.getBairro()) && Objects.equals(getCidade(), endereco1.getCidade()) && Objects.equals(getEstado(), endereco1.getEstado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogradouro(), getEndereco(), getNumero(), getBairro(), getCidade(), getEstado());
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
