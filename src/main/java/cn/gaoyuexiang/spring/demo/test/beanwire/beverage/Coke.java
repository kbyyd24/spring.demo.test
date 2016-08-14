package cn.gaoyuexiang.spring.demo.test.beanwire.beverage;

public class Coke {
	private String name;
	private String taste;

	@Override
	public String toString() {
		return "Coke{" +
						"name='" + name + '\'' +
						", taste='" + taste + '\'' +
						'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Coke coke = (Coke) o;

		return getName() != null ? getName().equals(coke.getName()) : coke.getName() == null && (getTaste() != null ? getTaste().equals(coke.getTaste()) : coke.getTaste() == null);

	}

	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getTaste() != null ? getTaste().hashCode() : 0);
		return result;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}
}
