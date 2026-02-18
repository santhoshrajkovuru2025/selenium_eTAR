package practice.Test_Class;

public class encpasulation {
	
	private int l =13;
	private String str = "encapsulation";
	
	public int getlen() {
		return l;
	}
	
	public String getstr() {
		return str;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		encpasulation en = new encpasulation();
		System.out.println(en.getlen());
		System.out.println(en.getstr());
	}

}
