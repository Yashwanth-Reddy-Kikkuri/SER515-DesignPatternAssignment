package SER515.ProductTBS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

	public ProductMenu CreateProductMenu() throws IOException {
		List<Product> productsList = this.getProducts();
		System.out.println("Displaying Menu");
		System.out.println(Arrays.deepToString(productsList.toArray()));
		String Category = null;
		int check = 0;
		while (check == 0) {
			System.out.println("Enter the productCategory that you want to select:");
			BufferedReader readerName = new BufferedReader(
					new InputStreamReader(System.in));
			String productName = readerName.readLine();
			for (Product product : productsList) {
				if (product.productCategory.equalsIgnoreCase(productName)) {
					Category = productName;
					check = 1;
					break;
				}
			}
			if (check == 1){
				break;
			}
			System.out.println("Product Category doesn't match. Please re-enter");
		}

		List<String> listOfProds = new ArrayList<>();
		ProductMenu productMenu = null;
		if (Category.equalsIgnoreCase("Meat")){
			productMenu = new MeatProductMenu();
		}
		else{
			productMenu = new ProduceProductMenu();
		}
		for (Product product : productsList){
			if (product.productCategory.equalsIgnoreCase(Category)){
				listOfProds.add(product.productName);
			}
		}
		productMenu.products.add(String.valueOf(listOfProds));
//		meatProductMenu.setMeatProduct();
		System.out.println(Arrays.deepToString(listOfProds.toArray()));

		return productMenu;
	}

}
