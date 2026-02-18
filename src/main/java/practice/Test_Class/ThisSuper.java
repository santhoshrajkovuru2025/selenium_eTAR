package practice.Test_Class;

class A{
	
	A(){ // Training_Youtube.Constructor
		System.out.println("Parent Training_Youtube.Constructor A");
	}
	
	A(int a){ // Training_Youtube.Constructor
		System.out.println("Parent Parameterized Training_Youtube.Constructor of Class A"); // Parameterized Training_Youtube.Constructor
		System.out.println(a);
	}
}
class B extends A{
	
	B(){ // Training_Youtube.Constructor
		System.out.println("Training_Youtube.Constructor of B");
	}
	B(int b){ // Training_Youtube.Constructor
        super(3);
		System.out.println("Parameterized Training_Youtube.Constructor of Child Class B"); // Parameterized constructor
		System.out.println(b);
	}
}

public class ThisSuper {
	public static void main(String[] args) {
		A a = new A(2);
		B b = new B(3);
	}
}
