
class Vehicle {

    void drive() {
        System.out.println("I am driving vehicle");
    }
}

class Car extends Vehicle {

    @Override
    void drive() {
        System.out.println("I am driving car");
    }

}

class Bike extends Vehicle {

    @Override
    void drive() {
        System.out.println("I am driving bike");
    }

}

public class RuntimePoly {

    public static void main(String[] args) {
        Vehicle vehicle1 = new Car();
        vehicle1.drive();

        Vehicle vehicle2 = new Bike();
        vehicle2.drive();

        Vehicle vehicle3 = new Vehicle();
        vehicle3.drive();
    }
}
