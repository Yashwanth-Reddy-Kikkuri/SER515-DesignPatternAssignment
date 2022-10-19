package SER515.ProductTBS;

import java.io.IOException;
import java.util.Arrays;

public class Buyer extends Person {

	private Person person;

	public Buyer(UserInfoItem userinfoitem) {
		this.userInfoItem = userinfoitem;
	}

	public void showMenu() {

	}

	@Override
	public void showComBoxes() {

	}

	/**
	 *  
	 */
	public ProductMenu CreateProductMenu() throws IOException {
		Facade facade = new Facade();
		facade.createProductList();
		ClassProductList productList = facade.getTheProductList();
		System.out.println("Displaying Menu");
		System.out.println(Arrays.deepToString(productList.getProducts().toArray()));
		return null;
	}

}
