package cn.gaoyuexiang.spring.demo.test.beanwire.cup;

import cn.gaoyuexiang.spring.demo.test.beanwire.beverage.Beverage;
import cn.gaoyuexiang.spring.demo.test.beanwire.beverage.Coke;
import cn.gaoyuexiang.spring.demo.test.beanwire.beverage.OrangeJuice;
import cn.gaoyuexiang.spring.demo.test.beanwire.config.CupConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CupConfig.class)
public class GlassCupTest {

	@Autowired
	private Coke coke;

	@Autowired
	private OrangeJuice orangeJuice;

	private GlassCup glassCup = new GlassCup();

	@Test
	public void drink_coke() throws Exception {
		glassCup.takeInWater(coke);
		Beverage pourBeverage = glassCup.pour();
		assertThat(pourBeverage, is(coke));
	}

	@Test
	public void cannot_change_beverage_if_not_null() throws Exception {
		glassCup.takeInWater(coke);
		glassCup.takeInWater(orangeJuice);
		Beverage pourBeverage = glassCup.pour();
		assertThat(pourBeverage, is(coke));
		assertThat(pourBeverage, not(orangeJuice));
	}

	@Test
	public void nothing_to_drink_if_null() throws Exception {
		Beverage pourBeverage = glassCup.pour();
		assertThat(pourBeverage, nullValue());
	}
}