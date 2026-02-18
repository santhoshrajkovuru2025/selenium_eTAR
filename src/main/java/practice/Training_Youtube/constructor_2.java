package practice.Training_Youtube;

public class  constructor_2{

    int a;
    String str;

    constructor_2(int a, String str) {

        this.a=a;
        this.str=str;
        System.out.println(str);
    }
}

    class test{
        void abc(){
            int a=20;
            String str="Santhosh1";
            System.out.println(a);
        }
        public static void main(String[] args) {
            constructor_2 c = new constructor_2(10,"Anvesh");
    }


}
