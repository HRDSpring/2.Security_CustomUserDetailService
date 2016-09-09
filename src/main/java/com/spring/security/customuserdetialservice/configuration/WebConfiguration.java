package com.spring.security.customuserdetialservice.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan({ "com.spring.security.customuserdetialservice.repository" })
@PropertySource(value = { "classpath:configuration.properties" })
public class WebConfiguration {
	
	@Autowired
	private Environment environment;

	/*@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("KA.dataSourcel.driverClassName"));
		dataSource.setUrl(environment.getProperty("KA.dataSourcel.url"));
		dataSource.setUsername(environment.getProperty("KA.dataSourcel.username"));
		dataSource.setPassword(environment.getProperty("KA.dataSourcel.password"));
		return dataSource;
	}*/

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("KA.dataSourcel.driverClassName"));
		dataSource.setUrl(environment.getProperty("KA.dataSourcel.url"));
		dataSource.setUsername(environment.getProperty("KA.dataSourcel.username"));
		dataSource.setPassword(environment.getProperty("KA.dataSourcel.password"));
		return dataSource;
	}

	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}
 
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		return sessionFactory;
	}

}
