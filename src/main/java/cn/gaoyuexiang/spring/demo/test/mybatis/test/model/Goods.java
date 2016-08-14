package cn.gaoyuexiang.spring.demo.test.mybatis.test.model;

public class Goods {
	private int id;
	private String name;
	private int price;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Goods goods = (Goods) o;

		if (getId() != goods.getId()) return false;
		if (getPrice() != goods.getPrice()) return false;
		return getName() != null ? getName().equals(goods.getName()) : goods.getName() == null;

	}

	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + getPrice();
		return result;
	}

	@Override
	public String toString() {
		return "Goods{" +
						"id=" + id +
						", name='" + name + '\'' +
						", price=" + price +
						'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
