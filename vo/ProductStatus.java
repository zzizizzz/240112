package vo;

public class ProductStatus {

	private int no;
	private String name;
	
	public ProductStatus() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductStatus [no=" + no + ", name=" + name + "]";
	}
	
	
	
}
