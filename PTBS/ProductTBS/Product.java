package SER515.ProductTBS;

public class Product {

	String productCategory;

	@Override
	public String toString() {
		return "Product{" +
				"productCategory='" + productCategory + '\'' +
				", productName='" + productName + '\'' +
				'}';
	}

	String productName;

	public Product(String productCategory, String productName) {
		this.productCategory = productCategory;
		this.productName = productName;
	}
}
