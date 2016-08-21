package cn.gaoyuexiang.spring.demo.test.aop;

import cn.gaoyuexiang.spring.demo.test.aop.car.Ferrari;
import cn.gaoyuexiang.spring.demo.test.aop.driver.Driver;
import cn.gaoyuexiang.spring.demo.test.aop.driver.license.License;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class CarConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
						new AnnotationConfigApplicationContext(CarConfig.class);
		System.out.println("-------------Spring context loaded-------------");
		Ferrari ferrari = context.getBean(Ferrari.class);
		Driver driver = context.getBean(Driver.class);
		driver.setLicense(new License("d23a"));
		int time = driver.drive(ferrari, 1000);
		System.out.println("spent " + time + " hours");
		System.out.println("-------------Spring context is going to close-----------");
		context.close();
	}
}
