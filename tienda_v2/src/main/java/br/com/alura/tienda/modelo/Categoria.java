package br.com.alura.tienda.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String nombre;

    public Categoria(String categoria) {
        this.nombre = categoria;
    }

    public Categoria() {

    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_cliente: " + id +
                ", nombre: " + nombre +"}";
    }
}
