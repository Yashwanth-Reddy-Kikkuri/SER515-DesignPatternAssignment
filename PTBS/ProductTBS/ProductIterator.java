package SER515.ProductTBS;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.ListIterator;

public class ProductIterator implements ListIterator {

	private Product[] classProductList;
	int pos;

	public ProductIterator(Product[] classProductList, int pos) {
		this.classProductList = classProductList;
		this.pos = 0;
	}

	public boolean hasNext() {
		if (this.pos < this.classProductList.length){
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		if (this.pos < this.classProductList.length){
			Product product = this.classProductList[this.pos];
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
		Product[] tempProdList = null;
		int i,j=0;
		for(i=0;i<this.classProductList.length;i++){
			if(j==this.pos){
				continue;
			}
			tempProdList[j] = this.classProductList[i];
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
		return null;
	}

	public void MoveToHead() {

	}

	public void Remove() {

	}

}
