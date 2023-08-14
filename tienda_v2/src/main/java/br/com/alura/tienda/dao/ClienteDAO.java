package br.com.alura.tienda.dao;

import br.com.alura.tienda.modelo.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {
    private final EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }
    public void insert(Cliente cliente){
        em.persist(cliente);
    }

    public void update(Cliente cliente){
        this.em.merge(cliente);
    }

    public void remove(Cliente cliente){
        cliente = this.em.merge(cliente);
        this.em.remove(cliente);
    }

    public Cliente selectById(Long id){
        return this.em.find(Cliente.class, id);
    }

    public List<Cliente> select(){
        String query = "SELECT C FROM Cliente as C";
        return em.createQuery(query, Cliente.class).getResultList();

    }
}
