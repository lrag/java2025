package com.curso.modelo.negocio;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Genero;

@Service
public class ServicioGeneros {
	
    private static List<Genero> generos;

	static {
        generos = new Vector<>();
        generos.add(new Genero(1, "Ci-Fi", "Ciencia Ficción"));
        generos.add(new Genero(2, "Accion", "Películas de acción"));
        generos.add(new Genero(3, "Comedia", "Películas cómicas"));
        generos.add(new Genero(4, "Western", "De tiros"));
	}
	
	public List<Genero> listarGeneros(){
		return generos;		
	}
	
}
