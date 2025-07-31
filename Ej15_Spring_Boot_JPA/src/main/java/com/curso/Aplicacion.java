package com.curso;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ServicioClientes;

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		ApplicationContext appCtx = SpringApplication.run(Aplicacion.class, args);
		
		ServicioClientes gc = appCtx.getBean(ServicioClientes.class);
		
		Cliente cli = new Cliente(null,"Lisa","C/Evergreen Terrace","555",5000);
		gc.insertar(cli);
		
		System.out.println("================================================");
		List<Cliente> clientes = gc.listar();
		clientes.forEach(c -> System.out.println(c.getNombre()));		
		
	}

}
