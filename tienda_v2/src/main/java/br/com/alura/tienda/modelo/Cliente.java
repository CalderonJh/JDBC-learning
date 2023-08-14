package br.com.alura.tienda.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id_cliente;
    private String nombre;
    private int cc;

    public Cliente(String nombre, int cc) {
        this.nombre = nombre;
        this.cc = cc;
    }

    public Cliente() {
    }

    public Long getId() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
}
