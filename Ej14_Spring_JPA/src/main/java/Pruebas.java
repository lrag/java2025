import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ServicioClientes;

public class Pruebas {

	public static void main(String[] args) {
		
		//Sin Spring:
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2PU");
		//EntityManager em = emf.createEntityManager();
		//...
		//em.close();
		
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);
		
		ServicioClientes gc = appCtx.getBean(ServicioClientes.class);
		
		Cliente cli = new Cliente(null,"Bart","C/Evergreen Terrace","555",5000);
		gc.insertar(cli);
		
		System.out.println("================================================");
		List<Cliente> clientes = gc.listar();
		clientes.forEach(c -> System.out.println(c.getNombre()));
		
		
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bbddClientes");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit();
		*/
	}
	
}





