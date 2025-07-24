import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.curso.modelo.entidad.Coche_Ciclo_De_Vida;

public class Pruebas_CicloDeVida {

	public static void main(String[] args) {		

		SessionFactory sf = new Configuration()
				.addAnnotatedClass(Coche_Ciclo_De_Vida.class)
                .setProperty("jakarta.persistence.jdbc.url", "jdbc:h2:file:C:/H2/hibernate6")
                .setProperty("jakarta.persistence.jdbc.user", "sa")
                .setProperty("jakarta.persistence.jdbc.password", "")
                .setProperty(SHOW_SQL, true)
                .setProperty(FORMAT_SQL, false)
                .setProperty(HIGHLIGHT_SQL, true)
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .buildSessionFactory();	

		Session s = null;
		
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		Coche_Ciclo_De_Vida c1 = new Coche_Ciclo_De_Vida(null, "Fiat", "Uno 45s", "M-5555-JP");
		s.persist(c1);
		
		s.getTransaction().commit(); //.rollback()
		s.close();
		
		//UPDATE CON TODOS LOS CAMPOS
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		Coche_Ciclo_De_Vida c2 = (Coche_Ciclo_De_Vida) s.get(Coche_Ciclo_De_Vida.class, c1.getId());
		c2.setMatricula("M-1234-JP");
		
		s.getTransaction().commit(); //.rollback()
		s.close();

		//DELETE
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		s.remove(c2); //Esto borra la pelicula si el id es correcto. si el id no es correcto: excepci�n

		s.getTransaction().commit();
		s.close();
		sf.close();
		
		
	}
	
}
















