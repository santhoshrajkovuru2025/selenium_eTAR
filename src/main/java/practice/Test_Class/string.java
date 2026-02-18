package practice.Test_Class;

public class string {

	public static void main(String[] args) {

		String str = new String("Java");
		str.concat(" world");
		System.out.println(str);
		
		
		StringBuffer str1 = new StringBuffer("Neo");
		str1.append(" Polis");
		System.out.println(str1);
		
	}

}
// String Builder and String Buffer classes
// mutable is String and immutable is String buffer
// Thread safe is String builder
