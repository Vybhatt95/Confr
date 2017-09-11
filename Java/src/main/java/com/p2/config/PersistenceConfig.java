package com.p2.config;

import oracle.jdbc.pool.OracleDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by August Duet on 9/6/2017.
 */
@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
public class PersistenceConfig {

    @Autowired
    Environment env;

    @Bean
    //create the datasource that hibernate will
    //use to connect to the DB
    public DataSource dataSource() throws SQLException {
        OracleDataSource ds = new OracleDataSource();

        System.out.println("Setting DB username to " + env.getRequiredProperty("hibernate.connection.username"));
        ds.setUser(env.getRequiredProperty("hibernate.connection.username"));
        ds.setPassword(env.getRequiredProperty("hibernate.connection.password"));

        System.out.println("Setting DB url to " + env.getRequiredProperty("hibernate.connection.url"));
        ds.setURL(env.getRequiredProperty("hibernate.connection.url"));

        System.out.println("Setting DB driver class to " + env.getRequiredProperty("hibernate.connection.driver-class"));
        ds.setDriverType(env.getRequiredProperty("hibernate.connection.driver-class"));

        return ds;
    }


    @Bean("sessionFactory")
    /*
    * this bean configures the session factory
    * it uses the DataSource create earlier*/
    public LocalSessionFactoryBean sessionFactory(DataSource ds){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(ds);
        sessionFactoryBean.setPackagesToScan("com.p2.Objects");

        Properties props = new Properties();
        props.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        props.put("hibernate.show_sql", true);
        props.put("hibernate.format_sql", true);

        sessionFactoryBean.setHibernateProperties(props);
        return sessionFactoryBean;
    }

    @Bean
    //Transaction Management
    public HibernateTransactionManager transactionManager(SessionFactory sf){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sf);
        return transactionManager;
    }
}
