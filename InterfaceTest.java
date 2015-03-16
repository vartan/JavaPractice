interface TestInterface {
	public String description();
}
class TestInterfaceMember implements TestInterface {
	public String description() {return "Test member";}
}
public class InterfaceTest {
	public static void main(String[] args) {
		TestInterface ta = new TestInterfaceMember();
		System.out.println(ta.description());
	}
}