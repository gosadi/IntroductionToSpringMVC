/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.config;


import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author alkinoos
 */
//theloume na sindesoume to Spring Framework me tin vasi kai gia na to kanoume auto xrisimopioume Hibernate kai kanoume kapia configurations
@Configuration
@EnableTransactionManagement //inform spring contentainer to take into account @nnotations about Transactional
public class DatabaseConfig {
    
    //datasource GIA TIN VASI
    private DataSource getDatasource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/sales?serverTimeZone=UTC");
        datasource.setUsername("root");
        datasource.setPassword("8VB9VNCMGNX6K");
        return datasource;
    }
    
    //hibernate properties
    private Properties getHibernateProperties(){
        //Properties object is something like a HashMap and its from JAVA
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL8Dialect"); 
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }
    
    //SessionFactory
    @Bean(name = "sessionFactory") //gia na to petaksoume ston SpringContainer
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        
        DataSource datasource = getDatasource();
        sessionFactory.setDataSource(datasource);
        
        Properties properties = getHibernateProperties();
        sessionFactory.setHibernateProperties(properties);
        
        sessionFactory.setPackagesToScan("emergon.entity");
        return sessionFactory;
    }
    //method to take care of transactions
    @Bean //Make HibernateTransactionManager a bean in order to go into a Spring Container gia auto pou epistrefei i methodos
    @Autowired //Inject SessionFactory into that method gia auto pou mpeni san parametro stin methodo epidi to exoume epano os @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sf){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sf);
        return txManager;
    }
}
