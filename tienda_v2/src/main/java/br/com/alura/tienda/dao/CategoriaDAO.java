package br.com.alura.tienda.dao;

import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.modelo.Producto;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private final EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Categoria categoria){
        em.persist(categoria);
    }

    public void update(Categoria categoria){
        this.em.merge(categoria);
    }

    public void remove(Categoria categoria){
        categoria=this.em.merge(categoria);
        this.em.remove(categoria);
    }



}

