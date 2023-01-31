package com.dominos.pilot_3.config;


import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource." + "postgresqlreadonly")
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresqlreadonly" + "EntityManagerFactory",
        transactionManagerRef = "postgresqlreadonly" + "TransactionManager",
        basePackages = {DatabaseConfig.BASE_ENTITY_PACKAGE_PREFIX + ".postgresqlreadonly"}
)
@MapperScan(
        basePackages = {DatabaseConfig.BASE_MAPPER_PACKAGE_PREFIX + ".postgresqlreadonly"}
)
public class PostgreSqlReadOnlyConfig extends DatabaseConfig{
    final String name = "postgresqlreadonly";

    @Bean(name = name + "DataSource")
    public DataSource dataSource() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(this));
    }

    /* --------------------mybatis 세팅-------------------- */
    @Bean(name = name + "SessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(name + "DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        setConfigureSqlSessionFactory(sqlSessionFactoryBean, dataSource);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = name + "SqlSessionTemplate")
    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier(name + "SessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /* --------------------JPA 세팅-------------------- */
    @Bean(name = name + "EntityManagerFactory")
    public EntityManagerFactory entityManagerFactory(@Qualifier(name + "DataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.pilot.dominos.domain.entity");
        localContainerEntityManagerFactoryBean.setPersistenceUnitName("postgresqlreadonly");
        setConfigureEntityManagerFactory(localContainerEntityManagerFactoryBean);

        return localContainerEntityManagerFactoryBean.getObject();
    }

    @Bean(name = name + "TransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier(name + "EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

        return jpaTransactionManager;
    }
}
