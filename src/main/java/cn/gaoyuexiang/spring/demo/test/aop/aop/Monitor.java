package cn.gaoyuexiang.spring.demo.test.aop.aop;

import cn.gaoyuexiang.spring.demo.test.aop.car.Car;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Monitor {

	@Pointcut(value = "execution(int cn.gaoyuexiang.spring.demo.test.aop.driver.Driver" +
					".drive(cn.gaoyuexiang.spring.demo.test.aop.car.Car, int)) " +
					"&& args(car, distance)")
	public void drive(Car car, int distance) {}

	@Before("drive(car, distance)")
	public void aboard(Car car, int distance) {
		String carName = car.getClass().getName();
		System.out.println("the driver will drive a " + carName +
						" to run " + distance + " kilometers");
	}
}
