package br.com.alura.tienda.modelo;

import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_pedido")
    private Long id;
    private int cantidad;
    private double precio_unidad;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public ItemPedido() {
    }

    public ItemPedido(int cantidad, Producto producto, Pedido pedido) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.pedido = pedido;
        this.precio_unidad = producto.getPrecio();
    }

    public Long getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(double precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
