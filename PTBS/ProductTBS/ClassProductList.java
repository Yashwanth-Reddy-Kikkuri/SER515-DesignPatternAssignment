package SER515.ProductTBS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassProductList extends Reminder {

	private ReminderVisitor reminderVisitor;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	private List<Product> products;

	private ProductIterator productIterator;

	ClassProductList() throws IOException {
		File file = new File("PTBS/ProductInfo.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String bt;
		products = new ArrayList<Product>();
		while ((bt = br.readLine()) != null) {
//			System.out.println(bt);
			String[] arrOfStr = bt.split(":");
			Product product = new Product(arrOfStr[0],arrOfStr[1]);
//			System.out.println(product);
			products.add(product);
		}

//		System.out.println(Arrays.deepToString(products.toArray()));
	}

	public Reminder accept(NodeVisitor visitor) {
		System.out.println("Classproductlist Reminder");
		for (Product product: this.products){
			return visitor.visitProduct(product);
		}
//		this.reminderVisitor.visitProduct();
		return null;
	}


}
