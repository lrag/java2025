package com.curso.modelo.negocio;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//Esta bean tiene una referencia al contenedor de Spring
public class BeanQueSabeDondeVive implements ApplicationContextAware, InitializingBean{

	private ApplicationContext appCtx;
	
	public BeanQueSabeDondeVive() {
		super();
		System.out.println("BeanQueSabeDondeVive.constructor");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("BeanQueSabeDondeVive: SET_APPLICATION_CONTEXT");
		this.appCtx = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanQueSabeDondeVive: AFTER_PROPERTIES_SET");
		BeanQueSabeComoSeLlama bean = appCtx.getBean("Venancia", BeanQueSabeComoSeLlama.class);
		bean.saludar();
	}

}
