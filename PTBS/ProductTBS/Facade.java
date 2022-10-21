package SER515.ProductTBS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	public ClassProductList getTheProductList() {
		return theProductList;
	}

	public void setTheProductList(ClassProductList theProductList) {
		this.theProductList = theProductList;
	}

	private ClassProductList theProductList;

	public Person getThePerson() {
		return thePerson;
	}

	public void setThePerson(Person thePerson) {
		this.thePerson = thePerson;
	}

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
		ReminderVisitor remind = new ReminderVisitor();
		Trading trading = new Trading();
		trading.accept(remind);
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
		List<String> productList = new ArrayList<String>();
		while ((bt = br.readLine()) != null) {
			String[] arrOfStr = bt.split(":");
			if (arrOfStr[0].equals(name)) {
				productList.add(arrOfStr[1]);
			}
		}

		List<Product> productL = new ArrayList<Product>();
		for(Product product : theProductList.getProducts()){
			if(productList.contains(product.productName)){
				productL.add(product);
			}
		}
		this.thePerson.setProducts(productL);
//		System.out.println(Arrays.deepToString(thePerson.getProducts().toArray()));

	}

	public Product SelectProduct() throws IOException {
		for(Product product : thePerson.getProducts()){
				System.out.println(product);
		}
		int check = 0;
		while (check == 0) {
			System.out.println("Enter the productName that you want to select:");
			BufferedReader readerName = new BufferedReader(
					new InputStreamReader(System.in));
			String productName = readerName.readLine();
			for (Product product : thePerson.getProducts()) {
				if (product.productName.equalsIgnoreCase(productName)) {
					return product;
				}
			}
			System.out.println("Product name doesn't match. Please re-enter");
		}
		return null;
	}

	public void productOperation() throws IOException {
//		System.out.println("Calling person createProductMenu");
//		int userType = thePerson.userInfoItem.getUserType();
//		ProductMenu productMenu = thePerson.CreateProductMenu();
		int userType = this.UserType;
		System.out.println("Bridge Design Pattern");
		ProductMenuFactory productMenu;
		if (userType == 0){
			Buyer buyer = new Buyer(thePerson.userInfoItem);
			productMenu = buyer.CreateProductMenu();
		}
		else{
			Seller seller = new Seller(thePerson.userInfoItem);
			productMenu = seller.CreateProductMenu();
		}
//		this.theProductMenu = productMenu;

		System.out.println("Iterator design pattern");
//		System.out.println(Arrays.deepToString(new ProductMenu[]{productMenu}));
		ProductIterator productIterator = new ProductIterator(productMenu.getProducts());
		List<Product> products = new ArrayList<>();
		while (productIterator.hasNext()){
//			System.out.println("a");
			products.add(productIterator.Next());
		}
		System.out.println(Arrays.deepToString(products.toArray()));
		System.out.println("Visitor Design Pattern");
		this.remind();
	}
}
