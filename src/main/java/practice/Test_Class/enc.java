
// Using the Getters and Setters methods in the encapsulation.

package practice.Test_Class;

public class enc {
  
	
	private int l;
	private String str;
	
	public int getlen() {
		return l;
	}
	
	public void setLen(int len) {
		this.l = len;
	}
	
	public String getstr() {
		return str;
	}
	
	public void setStr(String Str) {
		this.str = Str;
	}
	

	public static void main(String[] args) {

		enc en = new enc();
		en.setLen(13);
		en.setStr("Encapsulation");
		System.out.println(en.getlen());
		System.out.println(en.getstr());
	}

}
