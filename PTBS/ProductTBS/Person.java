package SER515.ProductTBS;

import java.util.List;

public abstract class Person implements ProductMenu {

	private ProductMenu theProductMenu;

	public List<Product> getProducts() {
		return Products;
	}

	public void setProducts(List<Product> products) {
		Products = products;
	}

	List<Product> Products;
	UserInfoItem userInfoItem;

	public void showMenu() {

	}

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
