package SER515.ProductTBS;

import java.io.*;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public boolean login() throws IOException {

		System.out.println("Enter you name:");
		BufferedReader readerName = new BufferedReader(
				new InputStreamReader(System.in));
		String name = readerName.readLine();
		System.out.println("Enter you password:");
		BufferedReader readerPass = new BufferedReader(
				new InputStreamReader(System.in));
		String pass = readerPass.readLine();
//		System.out.println(name);
//		System.out.println(pass);


		// If buyer is the one logging

		File file = new File("PTBS/BuyerInfo.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String bt;

		while ((bt = br.readLine()) != null) {
			String[] arrOfStr = bt.split(":");
//			System.out.println(arrOfStr[0]);

			if(arrOfStr[0].equals(name)){
//				System.out.println(arrOfStr[1]);

				if (arrOfStr[1].equals(pass)){
					createUser(new UserInfoItem(name, pass, 0));
					return true;
				}
				else{
					System.out.println("Password doesn't match for the username as Buyer");
					return false;
				}
			}
		}


		// If seller is the one logging

		File files = new File("PTBS/SellerInfo.txt");

		BufferedReader sr = new BufferedReader(new FileReader(files));

		String st;

		while ((st = sr.readLine()) != null) {
			String[] arrOfStr = st.split(":");

//			System.out.println(arrOfStr[0]);

			if(arrOfStr[0].equals(name)){
//				System.out.println(arrOfStr[1]);

				if (arrOfStr[1].equals(pass)){
					createUser(new UserInfoItem(name, pass, 1));
					return true;
				}
				else{
					System.out.println("Password doesn't match for the username as Seller");
					return false;
				}
			}
		}


		System.out.println("Username couldn't be found");
		return false;
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

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
