package com.cooory.ponderpal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.cooory.PonderPal.*")
public class DatabaseConfig {

//	 @Bean
//	    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//	        sessionFactory.setDataSource(dataSource);
//
//	        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
//	        sessionFactory.setMapperLocations(res);
//
//	        return sessionFactory.getObject();
//	    }

}
