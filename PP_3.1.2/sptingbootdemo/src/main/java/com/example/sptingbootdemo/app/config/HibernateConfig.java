//package config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Objects;
//import java.util.Properties;
//
//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = {"java"})
//@ComponentScan("java")
//public class HibernateConfig {
//
//	private Environment env;
//
//	public HibernateConfig(Environment env) {
//		this.env = env;
//	}
//
//	@Bean
//	public DataSource getDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("db.driver")));
//		dataSource.setUrl(env.getProperty("db.url"));
//		dataSource.setUsername(env.getProperty("db.username"));
//		dataSource.setPassword(env.getProperty("db.password"));
//		return dataSource;
//	}
//
//	@Bean
//	public AbstractEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean factoryBean
//				= new LocalContainerEntityManagerFactoryBean();
//		factoryBean.setDataSource(getDataSource());
//		factoryBean.setPackagesToScan("web");
//
//		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		factoryBean.setJpaVendorAdapter(vendorAdapter);
//		factoryBean.setJpaProperties(additionalProperties());
//
//
//		return factoryBean;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//		return transactionManager;
//	}
//
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
//
//	Properties additionalProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//
//		return properties;
//	}
//}