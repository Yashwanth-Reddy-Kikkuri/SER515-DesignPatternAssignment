package SER515.ProductTBS;

import java.io.*;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;
	public boolean login() throws IOException {
		Login log = new Login();
		UserType = log.login();
//		createUser(UserType);
		return true;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {


	}

	public void createProductList() throws IOException {
		theProductList = new ClassProductList();

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
