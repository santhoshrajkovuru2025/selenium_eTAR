package practice.Training_Youtube;

public class Constructor {

    int a;
    String str;

    Constructor(int a, String str) {
        this.a = a;
        this.str = str;
    }
    public static void main(String[] args) {

        Constructor c = new Constructor(1, "abc");
        System.out.println(c.a);
        System.out.println(c.str);



        }
    }

