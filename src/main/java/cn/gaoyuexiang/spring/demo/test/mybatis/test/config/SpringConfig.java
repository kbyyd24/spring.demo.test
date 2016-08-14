package cn.gaoyuexiang.spring.demo.test.mybatis.test.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.beans.PropertyVetoException;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = cn.gaoyuexiang.spring.demo.test.mybatis.test.dao.GoodsDao.class)
public class SpringConfig {

	private class DBEnvProperties {
		String driver;
		String jdbcUrl;
		String username;
		String password;
	}

	private DBEnvProperties getDBEnv() {
		DBEnvProperties properties = new DBEnvProperties();
		properties.driver = System.getenv("driver");
		properties.jdbcUrl = System.getenv("url");
		properties.username = System.getenv("username");
		properties.password = System.getenv("password");
		return properties;
	}

	@Bean
	public ComboPooledDataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		DBEnvProperties dbEnv = getDBEnv();
		try {
			dataSource.setDriverClass(dbEnv.driver);
			dataSource.setJdbcUrl(dbEnv.jdbcUrl);
			dataSource.setUser(dbEnv.username);
			dataSource.setPassword(dbEnv.password);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("classpath:Configuration.xml"));
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setTypeAliases(new Class[] {cn.gaoyuexiang.spring.demo.test.mybatis.test.model.Goods.class});
		sqlSessionFactoryBean.setMapperLocations(new Resource[] {new ClassPathResource("classpath:mapper/GoodsDao.xml")});
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBean().toString());
		configurer.setBasePackage("cn.gaoyuexiang.spring.demo.test.mybatis.test.dao");
		return configurer;
	}

}
