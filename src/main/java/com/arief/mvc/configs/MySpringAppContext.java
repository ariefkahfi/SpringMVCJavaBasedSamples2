package com.arief.mvc.configs;

import com.arief.mvc.entity.Doctor;
import com.arief.mvc.entity.Hospital;
import com.arief.mvc.entity.HospitalDirector;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.arief.mvc.daos"})
public class MySpringAppContext {


    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("arief");
        dataSource.setPassword("arief");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_tx3");
        return dataSource;
    }

    @Bean
    public Properties hibernateProps(){
        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto","update");
        props.setProperty("hibernate.show_sql","true");
        props.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(
            DataSource dataSource
    ){
        LocalSessionFactoryBean sessionFactoryBean
                =new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(hibernateProps());
        sessionFactoryBean.setAnnotatedClasses(
                Doctor.class,
                Hospital.class,
                HospitalDirector.class
        );
        return sessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hibernateTransactionManager
                =new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager){
        return new TransactionTemplate(transactionManager);
    }

}
