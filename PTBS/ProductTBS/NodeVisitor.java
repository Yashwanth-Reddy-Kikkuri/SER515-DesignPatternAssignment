package SER515.ProductTBS;

// This is the abstract class of visitor design pattern
public abstract class NodeVisitor {

	public abstract Reminder visitProduct(Product product);

	public Reminder visitTrading(Trading trading) {

		return null;
	}

	public void visitFacade(Facade facade) {

	}

}
