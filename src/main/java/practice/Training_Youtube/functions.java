package practice.Training_Youtube;

import java.util.Scanner;

public class functions {

   public static int printAdd(int x, int y){
        System.out.println("The sum is: "+(x+y));
        return x+y;
    }

    public static void main(String[] args) {
        // int  a=12;
       // int  b=13;
        System.out.println("Enter 2 Numbers");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
       printAdd(a,b);

    }
}
