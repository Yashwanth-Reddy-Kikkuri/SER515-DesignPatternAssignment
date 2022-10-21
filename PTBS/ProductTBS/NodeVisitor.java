package SER515.ProductTBS;

public abstract class NodeVisitor {

	public abstract Reminder visitProduct(Product product);

	public Reminder visitTrading(Trading trading) {

		return null;
	}

	public void visitFacade(Facade facade) {

	}

}
