import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.negocio.BeanCicloDeVida;
import com.curso.modelo.negocio.BeanQueSabeComoSeLlama;
import com.curso.modelo.negocio.BeanQueSabeDondeVive;
import com.curso.modelo.negocio.GestorClientes;

public class Pruebas {

	public static void main(String[] args) {
		
		AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans2.xml");
		
		System.out.println("=======================================");
		BeanCicloDeVida bean = appCtx.getBean(BeanCicloDeVida.class);
		
		/*
		System.out.println("=======================================");
		BeanQueSabeComoSeLlama bean2 = appCtx.getBean("Venancia",BeanQueSabeComoSeLlama.class);
		BeanQueSabeComoSeLlama bean3 = appCtx.getBean("Venancio",BeanQueSabeComoSeLlama.class);
		bean2.saludar();
		bean3.saludar();
		
		BeanQueSabeDondeVive bean4 = appCtx.getBean(BeanQueSabeDondeVive.class);
		*/
		
		System.out.println("=======================================");
		GestorClientes gc = appCtx.getBean(GestorClientes.class);
		gc.altaCliente("Bart");
		
		System.out.println("=======================================");
		appCtx.close();		
	}
	
}

