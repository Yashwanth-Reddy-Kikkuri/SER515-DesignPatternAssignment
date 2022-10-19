package SER515.ProductTBS;

import java.util.Arrays;
import java.util.List;

public class Seller extends Person {

	public Seller(UserInfoItem userinfoitem) {
		this.userInfoItem = userinfoitem;
	}

	public void showMenu() {

	}

	public void showComBoxes() {

	}

	public ProductMenu CreateProductMenu() {
		List<Product> productsList = this.getProducts();
		System.out.println("Displaying Menu");
		System.out.println(Arrays.deepToString(productsList.toArray()));
		return null;
	}

}
