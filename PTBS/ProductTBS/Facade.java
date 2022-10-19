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

		UserInfoItem userInfoItem = log.login();
		UserType = userInfoItem.getUserType();
		createUser(userInfoItem);
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
		int uType = userinfoitem.getUserType();
		if (uType == 0){
			thePerson = new Buyer(userinfoitem);
			System.out.println("Buyer");
		}
		if (uType == 1){
			thePerson = new Seller(userinfoitem);
			System.out.println("Seller");
		}

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
