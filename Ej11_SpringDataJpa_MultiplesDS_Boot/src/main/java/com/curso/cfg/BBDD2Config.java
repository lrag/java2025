package com.curso.cfg;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

//Producto
@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "bbdd2EntityManagerFactory", 
		transactionManagerRef = "bbdd2JpaTransactionManager", 
		basePackages = { "com.curso.modelo.persistencia.bbdd2" }
	)
public class BBDD2Config {
	
	@Bean
	@ConfigurationProperties("app.datasource.bbdd2")
	DataSourceProperties bbdd2DataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	DataSource bbdd2DataSource() {
		System.out.println("==============================================");
		System.out.println("CREANDO BBDD2_DATA_SOURCE");
		return bbdd2DataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}	
	
	@Bean
	LocalContainerEntityManagerFactoryBean 
		bbdd2EntityManagerFactory(DataSource bbdd2DataSource) {
		
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(bbdd2DataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.curso.modelo.entidad.bbdd2");
 
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        jpaProperties.put("hibernate.hbm2ddl.auto","update");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "false");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
 
        return entityManagerFactoryBean;
	}

	@Bean
	PlatformTransactionManager 
		bbdd2JpaTransactionManager(EntityManagerFactory bbdd2EntityManagerFactory) {
		return new JpaTransactionManager(bbdd2EntityManagerFactory);
	}

}