package Training_Youtube;

public class Static_Instance_Variable {

    int l =12;
    static String ch ="character";
    void value (){

        System.out.println(" "+ l);
    }
    public static void main(String[] args) {

        Static_Instance_Variable siv = new Static_Instance_Variable();
        Static_Instance_Variable siv1 = new Static_Instance_Variable();
        System.out.println("Instance Variable is: "+siv.l);
        System.out.println("Static variable is: "+ch);
        siv.value ();
        siv.l=500; Static_Instance_Variable.ch = "Ram";
        System.out.println("Instance Variable is: "+siv.l);
        System.out.println("Static variable is: "+siv1.l);
        System.out.println("Instance Variable is: "+Static_Instance_Variable.ch);
    }

}
