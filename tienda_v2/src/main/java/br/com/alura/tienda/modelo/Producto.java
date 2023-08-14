package br.com.alura.tienda.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long id;
	private String nombre;
	private  String descripcion;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	private LocalDate fecha = LocalDate.now();
	private Double precio;

	public Producto(String nombre, String descripcion, Categoria  categoria, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precio;
	}
	public Producto(String nombre, String descripcion, int  id_categoria, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = new Categoria();
		this.categoria.setId(id_categoria);
	}

	public Producto() {

	}


	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Producto{" +
				"id=" + id +
				", nombre: " + nombre +
				", descripcion: " + descripcion +
				", " + categoria.toString() +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
