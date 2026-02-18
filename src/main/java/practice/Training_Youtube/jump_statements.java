package practice.Training_Youtube;

public class jump_statements {

    public static void main (String[] args) {

        for(int i=0;i<=10;i++){

            if (i==5){
                break;
            }
            System.out.println("printing the statement of i: "+i);
        }
        System.out.println("for loop for i ends");

        for(int j=1;j<=20;j++){
            if(j==6) {
                continue;
            }
            System.out.println("printing the statement of j: "+j);
        }
        System.out.println("for loop for j ends");
    }


}
