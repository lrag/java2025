import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DatosBancarios;
import com.curso.modelo.entidad.Direccion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class PruebasOneToOne {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("H2PU");
			
		EntityManager em = null;
		
		Direccion d = new Direccion("Madrid", "C/Barquillo", "42", "28000");
		DatosBancarios db = new DatosBancarios(null, "Htb", 6000, null);
		Cliente c = new Cliente(null, "Montgomery Burns", "555", d, db);
		//Si la relación es bidireccional debemos cruzar las referencias:
		db.setCliente(c);
				
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Podemos guardarlos individualmente y en orden
		//em.persist(c);  //Aqui el cliente no tiene ID 
		//em.persist(db); //Aqui si
		
		//Como hemos definido la relación en las dos clases podriamos, insertando
		//solo un objeto, insertar los dos
		
		em.persist(c); //-> se insertan los DB por el cascade que hay en Cliente
		//em.persist(db); //-> se inserta el cliente por el cascade de DatosBancarios
		
		em.getTransaction().commit(); 
		em.close();		

		
		///////////
		//CASCADE//
		///////////
		System.out.println("==============================================");
		Integer idCliente = c.getId(); 
		Integer idDatosBancarios = db.getId();
		
		Direccion dd = new Direccion("Madrid", "C/Barquillo", "42", "280001");
		Cliente c2 = new Cliente(idCliente, "Montgomery Burns", "555", dd, null);
		DatosBancarios db2 = new DatosBancarios(idDatosBancarios, "Htb", 7777, c2);
		c2.setDatosBancarios(db2);
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(c2);
		//em.merge(db2);
		
		em.getTransaction().commit();
		em.close();

		
		emf.close();
	}
	
	
}
