package cn.gaoyuexiang.spring.demo.test.beanwire.config;

import cn.gaoyuexiang.spring.demo.test.beanwire.beverage.Beverage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Beverage.class)
public class CupConfig {

//	@Bean
//	public Coke coke() {
//		Coke coke = new Coke();
//		coke.setName("Coca Cola");
//		coke.setTaste("special");
//		return coke;
//	}
//
//	@Bean
//	public OrangeJuice orangeJuice() {
//		OrangeJuice orangeJuice = new OrangeJuice();
//		orangeJuice.setName("Fender Juice");
//		orangeJuice.setTaste("sweet");
//		return orangeJuice;
//	}
}
