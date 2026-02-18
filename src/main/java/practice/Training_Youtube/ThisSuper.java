package practice.Training_Youtube;

public class ThisSuper {
    String str = "Anvesh";
}
class child extends ThisSuper{

    String str="Santhosh";
    void show(){
        System.out.println(this.str);
        System.out.println(super.str);
    }
}

class name {
    public static void main(String[] args) {

        child child = new child();
        child.show();
    }
}