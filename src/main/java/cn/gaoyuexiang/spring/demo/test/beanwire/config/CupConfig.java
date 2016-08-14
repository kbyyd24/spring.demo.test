package cn.gaoyuexiang.spring.demo.test.beanwire.config;

import cn.gaoyuexiang.spring.demo.test.beanwire.beverage.Coke;
import cn.gaoyuexiang.spring.demo.test.beanwire.beverage.OrangeJuice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CupConfig {

	@Bean
	public Coke coke() {
		Coke coke = new Coke();
		coke.setName("Coca Cola");
		coke.setTaste("special");
		return coke;
	}

	@Bean
	public OrangeJuice orangeJuice() {
		OrangeJuice orangeJuice = new OrangeJuice();
		orangeJuice.setName("Fender Juice");
		orangeJuice.setTaste("sweet");
		return orangeJuice;
	}
}
