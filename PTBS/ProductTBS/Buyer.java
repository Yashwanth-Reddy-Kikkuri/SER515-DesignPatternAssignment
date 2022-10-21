package SER515.ProductTBS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	 * @return
	 */
	public ProductMenuFactory CreateProductMenu() throws IOException {
		Facade facade = new Facade();
		facade.createProductList();
		ClassProductList productList = facade.getTheProductList();
		System.out.println("Displaying Menu");
		System.out.println(Arrays.deepToString(productList.getProducts().toArray()));

		String Category = null;
		int check = 0;
		while (check == 0) {
			System.out.println("Enter the productCategory that you want to select:");
			BufferedReader readerName = new BufferedReader(
					new InputStreamReader(System.in));
			String productName = readerName.readLine();
			for (Product product : productList.getProducts()) {
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
		System.out.println("Factory Design Pattern");
		System.out.println("Factory Design Pattern will segregate between product menus based on category");
//		List<Product> listOfProds = new ArrayList<>();
		if (Category.equalsIgnoreCase("Meat")){
			ProductMenuFactory productMenu = new MeatProductMenu();
			for (Product product : productList.getProducts()){
				if (product.productCategory.equalsIgnoreCase(Category)){
					productMenu.products.add(product);
				}
			}
			System.out.println("Menu Created, using iterator design pattern to display it");
			return productMenu;
		}
		else{
			ProductMenuFactory productMenu = new ProduceProductMenu();
			for (Product product : productList.getProducts()){
				if (product.productCategory.equalsIgnoreCase(Category)){
					productMenu.products.add(product);
				}
			}
			System.out.println("Menu Created, using iterator design pattern to display it");
			return productMenu;
		}
//		productMenu.products = listOfProds;
//		meatProductMenu.setMeatProduct();

//		System.out.println(Arrays.deepToString(listOfProds.toArray()));

	}

}
