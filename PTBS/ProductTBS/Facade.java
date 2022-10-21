package SER515.ProductTBS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("fallthrough")
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

	// Here we can see the use of facade design pattern
	public boolean login() throws IOException {
		Login log = new Login();

		UserInfoItem userInfoItem = log.login();
		UserType = userInfoItem.getUserType();
		createUser(userInfoItem);
		return true;
	}

	@SuppressWarnings("fallthrough")
	public void addTrading() {

	}

	@SuppressWarnings("fallthrough")
	public void viewTrading() {
	System.out.println("viewTrading");
	}

	@SuppressWarnings("fallthrough")
	public void decideBidding() {
		System.out.println("decideBidding");

	}

	@SuppressWarnings("fallthrough")
	public void discussBidding() {
		System.out.println("discussBidding");

	}

	public void submitBidding() {
		System.out.println("submitBidding");
	}


	// Here we can see the use of visitor design pattern
	public void remind() throws IOException {
		ReminderVisitor remind = new ReminderVisitor();
		Reminder[] reminders = new Reminder[]{new Trading(),new ClassProductList(),new Trading()};
		for(Reminder reminder : reminders){
			reminder.accept(remind);
		}
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

	// This function acts as run time function which will call all the sub functions.
	// This includes internal and inside calls of Factory, Iterator, Bridge and Visitor design Pattern
	public void productOperation() throws IOException {
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

		System.out.println("Iterator design pattern");
		ProductIterator productIterator = new ProductIterator(productMenu.getProducts());
		List<Product> products = new ArrayList<>();
		while (productIterator.hasNext()){
			products.add(productIterator.Next());
		}
		System.out.println(Arrays.deepToString(products.toArray()));
		System.out.println("Visitor Design Pattern");
		this.remind();
	}
}
