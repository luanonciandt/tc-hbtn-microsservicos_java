package com.example.jpah2demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Telefone implements Serializable {

    private static final long seriaUIDVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DDD;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Telefone() {}

    public Telefone(String DDD, String numero) {
        this.DDD = DDD;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public String getDDD() {
        return DDD;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(getDDD(), telefone.getDDD()) && Objects.equals(getNumero(), telefone.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDDD(), getNumero());
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", DDD='" + DDD + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
