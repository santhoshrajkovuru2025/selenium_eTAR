package practice.Training_Youtube;

public class ClassName_Bike {

    static int wheels= 2;
        String color = "";

        static void Braking(){

            System.out.println("Bike halts when brakes applied");
    }
    void mileage(int s){

        System.out.println("mileage: "+s);
    }
    public static void main(String[] args) {

        ClassName_Bike Unicorn  = new ClassName_Bike();
        ClassName_Bike Pulsar  = new ClassName_Bike();
        ClassName_Bike R15 = new ClassName_Bike();
        Unicorn.color="Black";
        Pulsar.color="Blue";
        R15.color="Yellow";
        ClassName_Bike.Braking();
        ClassName_Bike.Braking();
        ClassName_Bike.Braking();
        Unicorn.mileage(60);
        Pulsar.mileage(50);
        R15.mileage(40);
        System.out.println("No of wheels in Unicorn: "+ ClassName_Bike.wheels);
        System.out.println("No of wheels in Pulsar: "+ ClassName_Bike.wheels);
        System.out.println("No of wheels in R15: "+ ClassName_Bike.wheels);
        System.out.println("The color of Unicorn is: "+Unicorn.color);
        System.out.println("The color of Pulsar is: "+Pulsar.color);
        System.out.println("The color of R15 is: "+R15.color);

    }
}
