package SER515.ProductTBS;

public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	private ClassProductList classProductList;

	@Override
	public Reminder visitProduct(Product product) {
		System.out.println("visit Product");
        return null;
    }

	@Override
	public Reminder visitTrading(Trading trading) {
		System.out.println("visit trading");
		return null;
	}

	@Override
	public void visitFacade(Facade facade) {
		System.out.println("visit facade");
	}

}
