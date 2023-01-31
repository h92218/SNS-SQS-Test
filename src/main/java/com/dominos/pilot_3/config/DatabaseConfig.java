package com.dominos.pilot_3.config;

import com.google.common.collect.ImmutableMap;
import com.zaxxer.hikari.HikariConfig;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.io.IOException;

public class DatabaseConfig extends HikariConfig {
    public static final String BASE_MAPPER_PACKAGE_PREFIX = "com.pilot.dominos.dao"; // dao 경로
    public static final String BASE_ENTITY_PACKAGE_PREFIX = "com.pilot.dominos.repository"; // jpa repository 경로

    protected void setConfigureEntityManagerFactory(LocalContainerEntityManagerFactoryBean configureEntityManagerFactory) {
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        configureEntityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        configureEntityManagerFactory.setJpaPropertyMap(ImmutableMap.of(
                "hibernate.hbm2ddl.auto", "none",
                /*
                 * create, create-drop, update, validate
                 * create : SessionFactory 시작시 스키마를 삭제하고 다시 생성
                 * create-drop : SessionFactory 종료시 스키마를 삭제
                 * update : SessionFactory 시작시 객체 구성와 스키마를 비교하여 컬럼 추가/삭제 작업을 진행함. 기존의 스키마를 삭제하지 않고 유지
                 * validate : SessionFactory 시작시 객체구성과 스키마가 다르다면 예외 발생시킴
                 * none : 자동 생성 기능을 사용하지 않음
                 * */
                "hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect",   // JPA가 직접 SQL을 작성 및 실행시 해당 DBMS 인지 하도록 해주는 설정
                "hibernate.show_sql", "true",   // DB에 전달하는 모든 쿼리 노출 (DDL, DML)
                "hibernate.format_sql", "true"  // 쿼리를 좋게 보여줌
        ));
        configureEntityManagerFactory.afterPropertiesSet();
    }

    protected void setConfigureSqlSessionFactory(SqlSessionFactoryBean sqlSessionFactoryBean, DataSource dataSource) throws IOException {
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources("classpath*:mybatis/mapper/**/*.xml"));
    }
}
