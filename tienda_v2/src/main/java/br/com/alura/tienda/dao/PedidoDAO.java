package br.com.alura.tienda.dao;

import br.com.alura.tienda.modelo.Pedido;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDAO {
    private final EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Pedido pedido){
        em.persist(pedido);
    }

    public void update(Pedido pedido){
        this.em.merge(pedido);
    }

    public void remove(Pedido pedido){
        pedido = this.em.merge(pedido);
        this.em.remove(pedido);
    }

    public Pedido selectById(Long id){
        return this.em.find(Pedido.class, id);
    }

    public List<Pedido> select(){
        String query = "SELECT P FROM Pedido as P";
        return em.createQuery(query, Pedido.class).getResultList();

    }

    public Double totalPrice(){
        String query = "SELECT sum(p.valor_compra) from Pedido as p";
        return em.createQuery(query, Double.class).getSingleResult();
    }

}
