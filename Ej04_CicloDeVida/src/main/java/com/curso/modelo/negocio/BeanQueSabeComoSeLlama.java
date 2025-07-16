package com.curso.modelo.negocio;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//Una bean que sabe cuál es si id/name
public class BeanQueSabeComoSeLlama implements BeanNameAware, InitializingBean {
	
	//Aqui guardaremos el id que le ha correspondido a la bean
	private String name;
	
	public BeanQueSabeComoSeLlama() {
		super();
		System.out.println("Bean que sabe como se llama. CONSTRUCTOR");
		System.out.println("name:"+name);
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
		System.out.println("Bean que sabe como se llama. SET_BEAN_NAME");
		System.out.println("name:"+name);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean que sabe como se llama. AFTER_PROPERTIES_SET");
		System.out.println("name:"+name);		
	}

	public void saludar() {
		System.out.println("¡Hola! Soy "+name);
	}	
	
}
