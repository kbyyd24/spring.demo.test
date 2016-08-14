package cn.gaoyuexiang.spring.demo.test.beanwire.cup;

import cn.gaoyuexiang.spring.demo.test.beanwire.beverage.Beverage;

public class GlassCup implements TakeInWaterable {

	private Beverage beverage;

	@Override
	public void takeInWater(Beverage beverage) {
		if (this.beverage == null)
			this.beverage = beverage;
	}

	@Override
	public Beverage pour() {
		if (beverage == null)
			return null;
		Beverage pourBev = beverage;
		beverage = null;
		return pourBev;
	}
}
