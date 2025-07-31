package com.curso.cfg;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.curso.modelo.entidad.bbdd1.Persona;
import com.curso.modelo.persistencia.bbdd1.PersonaRepositorio;
import com.zaxxer.hikari.HikariDataSource;

//Persona
@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "bbdd1EntityManagerFactory", 
		transactionManagerRef = "bbdd1JpaTransactionManager",
		basePackages = { "com.curso.modelo.persistencia.bbdd1" }
	)
public class BBDD1Config {
	
	@Bean
	@ConfigurationProperties("app.datasource.bbdd1")
	DataSourceProperties bbdd1DataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	DataSource bbdd1DataSource() {
		System.out.println("==============================================");
		System.out.println("CREANDO BBDD1_DATA_SOURCE");
		return bbdd1DataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean
	LocalContainerEntityManagerFactoryBean 
		bbdd1EntityManagerFactory(DataSource bbdd1DataSource) {
        
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(bbdd1DataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.curso.modelo.entidad.bbdd1");
 
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        jpaProperties.put("hibernate.hbm2ddl.auto","update");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "false");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
 
        return entityManagerFactoryBean;
	}
	
	//@Primary
	@Bean
	PlatformTransactionManager 
		bbdd1JpaTransactionManager(EntityManagerFactory bbdd1EntityManagerFactory) {
		return new JpaTransactionManager(bbdd1EntityManagerFactory);
	}	

}