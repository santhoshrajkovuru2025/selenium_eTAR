package practice.Test_Class;

class A1 {
    public void show(int a) {
        System.out.println("A1");
        System.out.println(11);
    }
}
class B1 extends A1{
    public void show(int a){
        System.out.println("B1");
        System.out.println(12);
    }
}
class C1 extends B1{
    public void show(int a){
        System.out.println("C1");
        System.out.println(10);
    }
}
public class inheritance {
    public static void main(String[] args) {
        C1 c1=new C1();
        c1.show(4);
    }
}
