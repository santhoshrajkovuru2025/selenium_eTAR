package practice.Test_Class;

class G {
    public void show(){

        System.out.println("I am G");
    }
}
    class H extends G{
        public void show2(){
            System.out.println("I am H");
    }
}
public class Dynamic_MethodDispatch {

    public static void main (String[] args){

        G obj = new H(); // Upcasting
        obj.show();

        H obj1 = (H) obj; // Down casting the method
        obj1.show();
        obj1.show2();



    }
}
