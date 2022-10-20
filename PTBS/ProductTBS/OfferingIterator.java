package SER515.ProductTBS;

public class OfferingIterator {

	private Offering[] offeringList;

	int pos;

	public OfferingIterator(Offering[] offeringList) {
		this.offeringList = offeringList;
		this.pos = pos;
	}

	public boolean hasNext() {
		if (this.pos < this.offeringList.length){
			return true;
		}
		return false;
	}

	public Offering Next() {
		if (this.pos < this.offeringList.length){
			Offering offering = this.offeringList[this.pos];
			this.pos += 1;
			return offering;
		}
		return null;
	}

	public void MoveToHead() {

	}

	public void Remove() {
		Offering[] tempProdList = null;
		int i,j=0;
		for(i=0;i<this.offeringList.length;i++){
			if(j==this.pos){
				continue;
			}
			tempProdList[j] = this.offeringList[i];
			j++;
		}
		this.offeringList = tempProdList;

	}

}
