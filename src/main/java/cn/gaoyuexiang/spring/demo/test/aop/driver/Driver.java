package cn.gaoyuexiang.spring.demo.test.aop.driver;

import cn.gaoyuexiang.spring.demo.test.aop.car.Car;
import cn.gaoyuexiang.spring.demo.test.aop.driver.license.License;

public class Driver {

	private License license;

	public Driver(License license) {
		this.license = license;
	}

	public int drive(Car car, int distance) {
		if (license == null) return -1;
		if (distance <= 0) return 0;
		if (car == null || car.getSpeed() <= 0) return -1;
		return distance / car.getSpeed() + 1;
	}
}
