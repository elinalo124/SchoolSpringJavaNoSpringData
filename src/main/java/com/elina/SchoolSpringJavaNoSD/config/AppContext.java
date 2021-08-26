package com.elina.SchoolSpringJavaNoSD.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement //enables Spring’s annotation-driven transaction management capability
public class AppContext {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); //creates a Hibernate SessionFactory
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.elina.SchoolSpringJavaNoSD.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("javax.persistence.jdbc.driver"));
        dataSource.setUrl(environment.getRequiredProperty("javax.persistence.jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("javax.persistence.jdbc.user"));
        dataSource.setPassword(environment.getRequiredProperty("javax.persistence.jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", environment.getRequiredProperty("hibernate.temp.use_jdbc_metadata_defaults"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        //binds a Hibernate Session from the specified factory to the thread, potentially allowing for one thread-bound Session per factory.
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
