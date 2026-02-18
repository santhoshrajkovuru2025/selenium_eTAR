package practice.Udemy;
class Person {

    public int display(int a, String n, double d, char c) {

        System.out.println("Display the values");
        System.out.println("No. of persons: " + a);
        System.out.println("Name of the person: " + n);
        System.out.println("Age in days: " + d);
        System.out.println("Gender:" + c);
        return a;
    }
}
public class learningMethods {

    public static void main(String[] args) {

        Person p = new Person();
        p.display(1, "Swaroop", 32.120,'M');

    }
}
