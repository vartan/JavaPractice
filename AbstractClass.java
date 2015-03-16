abstract class TestAbstract {
	public abstract String description();
}
class TestAbstractMember extends TestAbstract {
	public String description() {return "Test member";}
}
public class AbstractClass {
	public static void main(String[] args) {
		TestAbstract ta = new TestAbstractMember();
		System.out.println(ta.description());
	}
}