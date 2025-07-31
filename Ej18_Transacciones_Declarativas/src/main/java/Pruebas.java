import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.ServicioPedidos;

public class Pruebas {

	public static void main(String[] args) {
		
		AbstractApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);
		
		System.out.println("=================================================");		
		
		ServicioPedidos gp = appCtx.getBean(ServicioPedidos.class);
		try {
			gp.aceptar(3);
		} catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
		}		
				
		EntityManagerFactory emf = appCtx.getBean(EntityManagerFactory.class);
		
		System.out.println("=================================================");
		EntityManager em = emf.createEntityManager();
		List<Producto> productos = em.createQuery("select p from Producto p").getResultList();
		productos.forEach( e -> System.out.println(e) );

		System.out.println("=================================================");
		List<Pedido> pedidos = em.createQuery("select p from Pedido p").getResultList();
		pedidos.forEach( e -> System.out.println(e) );
		
		em.close();
		
		
		/*
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
		*/
		
		appCtx.close();
		
	}
	
}
















