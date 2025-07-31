package com.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.GestorPedidos;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired
	private GestorPedidos gestorPedidos;
	
	@Autowired
	private EntityManagerFactory emf;
	
	public static void main(String[] args) {	
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("=================================================");		
		
		try {
			gestorPedidos.aceptar(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		

		System.out.println("=================================================");
		EntityManager em = emf.createEntityManager();
		List<Producto> productos = em.createQuery("select p from Producto p").getResultList();
		productos.forEach( e -> System.out.println(e) );

		System.out.println("=================================================");
		List<Pedido> pedidos = em.createQuery("select p from Pedido p").getResultList();
		pedidos.forEach( e -> System.out.println(e) );
		
		em.close();
		
		System.out.println("=================================================");
		em = emf.createEntityManager();
		Pedido p2 = em.find(Pedido.class, 2);
		System.out.println(p2.getCodigo());
		System.out.println(p2.getCliente().getNombre());
		
		p2.getDetalles().size();
	
		em.close();

		for(DetallePedido dp : p2.getDetalles()) {
			System.out.println(dp.getProducto().getNombre());
		}
		
	}

}
