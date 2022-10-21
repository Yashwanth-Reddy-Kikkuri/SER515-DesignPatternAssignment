package SER515.ProductTBS;

public class Trading extends Reminder {

	private Product product;

	private OfferingList offeringList;

	public Reminder accept(NodeVisitor visitor) {
		System.out.println("Trading Reminder");
		return visitor.visitTrading(this);
	}

}
