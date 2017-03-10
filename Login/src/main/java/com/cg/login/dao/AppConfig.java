package com.cg.login.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cg.login.model.Customer;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	/*@Bean
	public CustomerDao customerDao() {
		return new CustomerDao();
	}*/
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}

	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Customer.class).buildSessionFactory();
	}

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
/*		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
*/		//dataSource.setUsername("root");
		//dataSource.setPassword("");

		return dataSource;
	}

	/*@Bean
	public HibernateTransactionManager hibTransMan() {
		return new HibernateTransactionManager(sessionFactory());
	}*/
}
