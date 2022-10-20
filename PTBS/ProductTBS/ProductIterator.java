package SER515.ProductTBS;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ProductIterator implements ListIterator {

	private List<Product> classProductList;
	int pos;

	public ProductIterator(List<Product> classProductList) {
		this.classProductList = classProductList;
		this.pos = 0;
	}

	public boolean hasNext() {
		if (this.pos < this.classProductList.size()){
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		if (this.pos < this.classProductList.size()){
			Product product = this.classProductList.get(this.pos);
			this.pos += 1;
			return product;
		}
		return null;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public Object previous() {
		return null;
	}

	@Override
	public int nextIndex() {
		return this.pos++;
	}

	@Override
	public int previousIndex() {
		return this.pos-1;
	}

	@Override
	public void remove() {
		List<Product> tempProdList = new ArrayList<>();
		int i,j=0;
		for(i=0;i<this.classProductList.size();i++){
			if(j==this.pos){
				continue;
			}
			tempProdList.set(j, this.classProductList.get(i));
			j++;
		}
		this.classProductList = tempProdList;
	}

	@Override
	public void set(Object o) {

	}

	@Override
	public void add(Object o) {

	}

	public Product Next() {
		if (this.pos < this.classProductList.size()){
			Product product = this.classProductList.get(this.pos);
			this.pos += 1;
			return product;
		}
		return null;
	}

	public void MoveToHead() {

	}

	public void Remove() {

	}

}
