package ru.playgroud.jpa.boot;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("ru.playgroud.jpa")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("ru.playgroud.jpa.repository")
public class ApplicationConfiguration {
  
  /*
   * specify data source driver class for mysql(fetched form application properties)
   */
  @Value("${core.datasource.driverclass}")
  private String CORE_DATASOURCE_DRIVE_CLASS;
  
  /* specify url(fetched form application properties) */
  @Value("${core.datasource.url}")
  private String CORE_DATASOURCE_URl;
  
  /* specify url (fetched form application properties) */
  @Value("${core.datasource.username}")
  private String CORE_DATASOURCE_USERNAME;
  
  /* specify password(fetched form application properties) */
  @Value("${core.datasource.password}")
  private String CORE_DATASOURCE_PASSWORD;
  
  
  /**
   * Create data source bean for given data base.
   * 
   * @return Data source for access the database.
   */
  @Bean
  @Qualifier("dataSource")
  public DataSource dataSource() {
  
    BasicDataSource dataSource = new BasicDataSource();
    
    dataSource.setDriverClassName(CORE_DATASOURCE_DRIVE_CLASS);
    dataSource.setUrl(CORE_DATASOURCE_URl);
    dataSource.setUsername(CORE_DATASOURCE_USERNAME);
    dataSource.setPassword(CORE_DATASOURCE_PASSWORD);
    // dataSource.setPoolPreparedStatements(CORE_DATASOURCE_POOLPREPARED_ST);
    
    return dataSource;
  }
  
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
  
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource());
    entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
    /*
     * entityManagerFactoryBean .setPersistenceProviderClass(HibernatePersistence.class);
     */
    entityManagerFactoryBean.setPackagesToScan("ru.playgroud.jpa.model");
    return entityManagerFactoryBean;
  }
  
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
  
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setShowSql(true);
    hibernateJpaVendorAdapter.setGenerateDdl(true);
    hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
    
    return hibernateJpaVendorAdapter;
    
  }
  
  @Bean
  @Qualifier("transactionManager")
  public JpaTransactionManager transactionManager() {
  
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }
  
  /**
   * Load the properties from property file and make available all properties throughout the
   * application,Property can access @value annotation.
   * 
   * @return PropertySourcesPlaceholderConfigurer
   */
  @Bean
  public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
  
    PropertyPlaceholderConfigurer util = new PropertyPlaceholderConfigurer();
    util.setLocations(new Resource[] {new ClassPathResource("application.properties")});
    return util;
  }
}
