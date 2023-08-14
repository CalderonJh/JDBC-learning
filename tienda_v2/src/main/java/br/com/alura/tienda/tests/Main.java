package br.com.alura.tienda.tests;

import javax.persistence.EntityManager;
import br.com.alura.tienda.dao.*;

import static br.com.alura.tienda.utils.JPAUtils.*;

public class Main {

	public static void main(String[] args) {
	    EntityManager em = getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		em.getTransaction().begin();
//		 --------
//		System.out.println(pedidoDAO.totalPrice());
//		Cliente jhon = clienteDAO.selectById(1L);
//		Pedido pedido1 = new Pedido(jhon);
//		Producto producto = productoDAO.selectById(13L);
//		Producto producto2 = productoDAO.selectById(4L);
//
//
//		pedido1.addItems(new ItemPedido(1, producto, pedido1));
//		pedido1.addItems(new ItemPedido(2, producto2, pedido1));
//		pedidoDAO.insert(pedido1);
		
		var p =productoDAO.selectByParameters("", null);
		System.out.println(p);
		em.getTransaction().commit();
		em.close();
	}

}
