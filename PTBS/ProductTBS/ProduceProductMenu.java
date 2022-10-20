package SER515.ProductTBS;

import java.util.List;

public class ProduceProductMenu implements ProductMenu {
	public List<String> getProduceProduct() {
		return produceProduct;
	}

	public void setProduceProduct(List<String> produceProduct) {
		this.produceProduct = produceProduct;
	}

	List<String> produceProduct;
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
