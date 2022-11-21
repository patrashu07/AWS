package com.green.nowon.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {
	//요규사항
	//sqlsessionfactory 
	// SqlSessionFactoryBean 을 통해서 객체 생성 sqlsessionfactory(인터페이스)
	//datasource : jpa 적용
	//sqlSessionfactoryTemplet
	
	@Autowired
	ApplicationContext ac;
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSource);
		ssfb.setConfiguration(myMybatisConfig());
		
		String locationPattern="classpath:mapper/**/*-mapper.xml";
		Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources(locationPattern);
//		Resource[] mapperLocations=ac.getResources(locationPattern);
		ssfb.setMapperLocations(mapperLocations);
		
		return  ssfb.getObject();
	}
	
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(DataSource dataSource) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory(dataSource));
	}
	
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration myMybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
}
