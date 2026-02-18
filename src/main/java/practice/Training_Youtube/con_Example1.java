package practice.Training_Youtube;

class Employee {

    String Name;
    int id;

    Employee() {

       System.out.println("Training_Youtube.Employee constructor");
    }
    Employee(String name, int id){
        this.Name=name;
        this.id=id;
        System.out.println("Training_Youtube.Employee one constructor");
    }
}

public class con_Example1 {
    public static void main(String[] args) {
        Employee e =new Employee();
        Employee e1 = new Employee("Santhosh",1984);
        System.out.println(e1.Name);
        System.out.println(e1.id);
    }
}
