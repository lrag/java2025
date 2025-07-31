package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.curso.modelo.negocio","com.curso.modelo.persistencia"})
@EnableTransactionManagement //<tx:annotation-driven/>
public class Configuracion {

	/*
	<bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="org.h2.Driver" />
		<property name="url"             value="jdbc:h2:file:c:/h2/bbdd" />
		<property name="username"        value="sa" />
		<property name="password"        value="" />
	</bean>	
	*/
	@Bean
	public DataSource datasource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bbdd");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	/*
	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		<property name="dataSource" ref="datasource"/>
	</bean>
	*/
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource datasource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		return jdbcTemplate;
	}

	/*
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"/>
	</bean>	
	*/
	@Bean
	@Autowired
	public DataSourceTransactionManager transactionManager(DataSource dataSource){
		DataSourceTransactionManager txM = new DataSourceTransactionManager();
		txM.setDataSource(dataSource);
		return txM;
	}
	
}







