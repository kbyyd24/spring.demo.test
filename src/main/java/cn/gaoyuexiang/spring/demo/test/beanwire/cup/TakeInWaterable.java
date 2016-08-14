package cn.gaoyuexiang.spring.demo.test.beanwire.cup;

import cn.gaoyuexiang.spring.demo.test.beanwire.beverage.Beverage;

public interface TakeInWaterable {
	void takeInWater(Beverage beverage);

	Beverage pour();
}
