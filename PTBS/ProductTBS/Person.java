package SER515.ProductTBS;

import java.io.IOException;
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
		System.out.println("Add button");
	}

	public void showViewButton() {
		System.out.println("View button");
	}

	public void showRadioButton() {
		System.out.println("Radio button");
	}

	public void showLabels() {
		System.out.println("labels");
	}

	public ProductMenu CreateProductMenu() throws IOException {
		int userType = userInfoItem.getUserType();
		ProductMenu productMenu = null;
		System.out.println("Factory Design Pattern");
		if (userType == 0){
			Buyer buyer = new Buyer(userInfoItem);
			productMenu = buyer.CreateProductMenu();
		}
		else{
			Seller seller = new Seller(userInfoItem);
			productMenu = seller.CreateProductMenu();
		}
		this.theProductMenu = productMenu;
		return productMenu;
	}
}
