package SER515.ProductTBS;

import java.util.List;


public class MeatProductMenu implements ProductMenu {
	List<String> meatProduct;

	public List<String> getMeatProduct() {
		return this.meatProduct;
	}

	public void setMeatProduct(List<String> meatProduct) {
		this.meatProduct = meatProduct;
	}

	public void showMenu() {

	}

	public void showAddButton() {
		System.out.println("add");
	}

	public void showViewButton() {
		System.out.println("view");
	}

	public void showRadioButton() {
		System.out.println("radio");
	}

	public void showLabels() {
		System.out.println("labels");
	}

	public void showComBoxes() {
		System.out.println("Com boxes");
	}

}
