package com.curso.cfg;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class Configuracion {

	
	/*
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"/>
		<property name="url" value="jdbc:mysql://localhost:3306/bbdd"/>
		<property name="username" value="root" />
		<property name="password" value="root" />
	</bean>
	*/	
	
	@Bean
	DataSource dataSource() {
		System.out.println("=====================================================");
		System.out.println("Creando el datasource");

		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:h2:file:c:/h2/bbdd_spring_jpa");
		ds.setDriverClassName("org.h2.Driver");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		//Usaremos este datasource para que JPA obtenga las conexiones
		entityManagerFactoryBean.setDataSource(dataSource);
		//La implementación será Hibernate
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		//Las clase marcadas con @Entity están en este paquete
		entityManagerFactoryBean.setPackagesToScan("com.curso.modelo.entidad");

		//Configuración específica para Hibernate
		Properties jpaProperties = new Properties();
		//Dialecto de sql
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		//validate: comprueba que la configuración coincide con lo que hay en la bb.dd. pero no toca nada
		//create: al arrancar crea las tablas (y si tienen datos se los cepilla)
		//update: si las tablas no existen las crea pero respeta los datos
		//create-drop: crea la base de datos al arranca y la elimina al parar la aplicacion
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.format_sql", "false");
		jpaProperties.put("hibernate.highlight_sql", "true");
		
		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}	
	
	
}
