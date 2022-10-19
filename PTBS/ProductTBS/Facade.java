package SER515.ProductTBS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public void AttachProductToUser() throws IOException {
		File file = new File("PTBS/UserProduct.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String bt;
		String name = thePerson.userInfoItem.getName();
		System.out.println(name);
		List<String> productList = new ArrayList<String>();
		while ((bt = br.readLine()) != null) {
			String[] arrOfStr = bt.split(":");
			if (arrOfStr[0].equals(name)) {
				productList.add(arrOfStr[1]);
			}
		}
		System.out.println(Arrays.deepToString(productList.toArray()));
		List<Product> productL = new ArrayList<Product>();
		for(Product product : theProductList.getProducts()){
			if(productList.contains(product.productName)){
				productL.add(product);
			}
		}
		thePerson.setProducts(productL);
		System.out.println(Arrays.deepToString(thePerson.getProducts().toArray()));

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
