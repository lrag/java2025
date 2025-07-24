import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Pruebas_GenerationType_Table {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		//El entity manager factory es threadsafe
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2PU");
		
		//El entity manager tiene dentro una conexión asi que NO ES THREAD-SAFE
		EntityManager em = null;
		
		System.out.println("=========================================");
		
		Cliente c1 = new Cliente(null,"N1","D1","T1");
		Cliente c2 = new Cliente(null,"N2","D2","T2");
		Cliente c3 = new Cliente(null,"N3","D3","T3");
		Cliente c4 = new Cliente(null,"N4","D4","T4");
		Cliente c5 = new Cliente(null,"N5","D5","T5");
		Producto p1 = new Producto(null, "N1", "F1", 1d);
		Producto p2 = new Producto(null, "N2", "F2", 2d);
		Producto p3 = new Producto(null, "N3", "F3", 3d);
		Producto p4 = new Producto(null, "N4", "F4", 4d);
		Producto p5 = new Producto(null, "N5", "F5", 5d);
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c1); 
		em.persist(c2); 
		em.persist(c3); 
		em.persist(c4); 
		em.persist(c5); 
		em.persist(p1); 
		em.persist(p2); 
		em.persist(p3); 
		em.persist(p4); 
		em.persist(p5); 
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		
		em.getTransaction().commit(); 
		em.close();		
		
		emf.close();
		
		System.out.println("=========================================");
		Connection cx = DriverManager.getConnection("jdbc:h2:file:C:/H2/hibernate6","sa","");
		PreparedStatement pst = cx.prepareStatement("select * from TABLA_IDS");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+", "+rs.getInt(2));
		}
		cx.close();
		
	}
	
}







