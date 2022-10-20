package SER515.ProductTBS;

import java.util.ArrayList;
import java.util.List;

public class ProductMenuFactory implements ProductMenu {
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    List<Product> products = new ArrayList<>();


    @Override
    public void showMenu() {

    }

    @Override
    public void showAddButton() {

    }

    @Override
    public void showViewButton() {

    }

    @Override
    public void showRadioButton() {

    }

    @Override
    public void showLabels() {

    }

    @Override
    public void showComBoxes() {

    }
}
