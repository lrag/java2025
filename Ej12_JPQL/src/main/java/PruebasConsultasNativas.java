import java.util.List;

import com.curso.modelo.entidad.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class PruebasConsultasNativas {

	public static void main(String[] args) {
		
		//El entity manager factory es threadsafe
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2PU");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Insert, update, delete
		System.out.println("======================================");
		Query q1 = em.createNativeQuery("insert into cliente (nombre, ciudad, calle, telefono) values (?,?,?,0)");
		q1.setParameter(1, "Chowder");
		q1.setParameter(2, "Su ciudad");
		q1.setParameter(3, "Su casa");
		q1.executeUpdate(); 
		
		//Select
		System.out.println("======================================");
		Query q2 = em.createNativeQuery("select nombre, calle from cliente");
		List<Object[]> rs = q2.getResultList();
		for(Object[] array: rs){
			System.out.println(array[0]+","+array[1]);
		}
		
		System.out.println("======================================");
		Query q3 = em.createNativeQuery("select * from cliente", Cliente.class);
		List<Cliente> rs2 = q3.getResultList();
		for(Cliente c: rs2){
			System.out.println(c);
		}
		
		em.getTransaction().commit();
		em.close();			
		emf.close();
	}
	
	
}