package br.com.alura.tienda.dao;

import br.com.alura.tienda.modelo.Producto;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private final EntityManager em;

    public ProductoDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Producto producto){
        em.persist(producto);
    }
    public void update(Producto producto){
        this.em.merge(producto);
    }

    public void remove(Producto producto){
        producto = this.em.merge(producto);
        this.em.remove(producto);
    }

    public Producto selectById(Long id){
        return this.em.find(Producto.class, id);
    }

    public List<Producto> select(){
        String query = "SELECT P FROM Producto as P";
        return em.createQuery(query, Producto.class).getResultList();

    }

    public List<Producto> selectByName(String name){
        String query = "SELECT P FROM Producto AS P WHERE P.nombre =:name";
        return em.createQuery(query,Producto.class).setParameter("name", name).getResultList();
    }

    public List<Producto> selectByNameLike(String name){
        String query = "SELECT P FROM Producto AS P WHERE P.nombre like :name";
        return em.createQuery(query,Producto.class).setParameter("name", "%" + name + "%").getResultList();
    }

    public List<Producto> selectByCategoria(String nombreCategoria){
        String query = "select P FROM Producto as P" +
                " WHERE P.categoria.nombre =: c";
        return em.createQuery(query, Producto.class).setParameter("c", nombreCategoria).getResultList();
    }

    public List<Producto> selectByCategoriaLimit(String nombreCategoria, int limit){
        String query = "select P FROM Producto as P" +
                " WHERE P.categoria.nombre =: c";
        return em.createQuery(query, Producto.class)
                .setParameter("c", nombreCategoria)
                .setMaxResults(limit)
                .getResultList();
    }

    public List<Producto> selectByParameters(String nombre, Double precio){
        StringBuilder jpql = new StringBuilder("select p from Producto p where 1=1 " );
        if(nombre !=null && !nombre.trim().isEmpty()){
            jpql.append("and p.nombre =: nombre");
        }if(precio != null){
            jpql.append(" and p.precio =: precio");
        }
        var query = em.createQuery(jpql.toString(), Producto.class);
        if(nombre !=null && !nombre.trim().isEmpty()){
            query.setParameter("nombre", nombre);
        }if(precio != null){
            query.setParameter("precio", precio);
        }
        return query.getResultList();
    }

}
