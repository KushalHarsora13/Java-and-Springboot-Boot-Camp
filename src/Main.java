/*
 * ==========================
 * INTERFACES (Abstraction)
 * ==========================
 * Interfaces define contracts that implementing classes must follow.
 */

interface VehicleInterface {
    void run();
}

interface VehicleInterface2 {
    void run2();
}

/*
 * ==========================
 * ENCAPSULATION
 * ==========================
 * Data is hidden using private variables.
 * Access is provided through public methods.
 */

class Vehicle {

    // Private data member (hidden from outside classes)
    private int chassis = 101;

    Vehicle() {
        System.out.println("Vehicle Constructor");
    }

    // Getter method
    public int getChassisNumber() {
        return chassis;
    }

    // Setter method
    public void setChassisNumber(int chassis) {
        this.chassis = chassis;
    }

    public void getChassis() {
        System.out.println("Chassis -> " + chassis);
    }
}

/*
 * ==========================
 * INHERITANCE
 * ==========================
 * Car inherits properties and methods from Vehicle.
 */

class Car extends Vehicle {

    private int id;
    protected String name;
    public int hp;

    Car() {
        System.out.println("Car Constructor");
    }

    /*
     * POLYMORPHISM (Method Overriding)
     * Same method name as parent class,
     * but different implementation.
     */
    @Override
    public void getChassis() {
        super.getChassis();
        System.out.println("Inside Car Override");
    }

    public void display() {
        System.out.println("Inside Car Display");
    }
}

/*
 * Another child class of Vehicle
 */
class Bike extends Vehicle {

    private int id;

    Bike() {
        System.out.println("Bike Constructor");
    }

    @Override
    public void getChassis() {
        super.getChassis();
        System.out.println("Inside Bike Override");
    }
}

/*
 * ==========================
 * POLYMORPHISM
 * ==========================
 * Method Overloading
 * Same method name, different parameters.
 */

class CalculatorMain {

    CalculatorMain() {
        System.out.println("Calculator Constructor");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

/*
 * ==========================
 * ABSTRACTION
 * ==========================
 * Abstract class can contain both
 * abstract and concrete methods.
 */

abstract class VehicleClass {

    // Abstract method
    public abstract void display();

    // Concrete method
    public void show() {
        System.out.println("Vehicle Show Method");
    }
}

/*
 * CarClass implements interfaces and extends abstract class
 */
class CarClass extends VehicleClass
        implements VehicleInterface, VehicleInterface2 {

    @Override
    public void display() {
        System.out.println("Inside CarClass Display");
    }

    @Override
    public void run() {
        System.out.println("Car is Running");
    }

    @Override
    public void run2() {
        System.out.println("Car run2()");
    }
}

/*
 * Another implementation of abstract class
 */
class BikeClass extends VehicleClass {

    @Override
    public void display() {
        System.out.println("Inside BikeClass Display");
    }
}

/*
 * ==========================
 * MAIN CLASS
 * ==========================
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("===== ENCAPSULATION =====");

        Vehicle vehicle = new Vehicle();

        // Using setter
        vehicle.setChassisNumber(500);

        // Using getter
        System.out.println(
                "Chassis Number = "
                        + vehicle.getChassisNumber());

        System.out.println("\n===== INHERITANCE =====");

        Car car = new Car();
        car.getChassis();

        Bike bike = new Bike();
        bike.getChassis();

        System.out.println("\n===== POLYMORPHISM =====");

        CalculatorMain calc = new CalculatorMain();

        System.out.println(
                "add(int,int) = "
                        + calc.add(10, 20));

        System.out.println(
                "add(int,int,int) = "
                        + calc.add(10, 20, 30));

        System.out.println("\n===== METHOD OVERRIDING =====");

        Vehicle vehicleRef = new Car();

        // Runtime Polymorphism
        vehicleRef.getChassis();

        System.out.println("\n===== ABSTRACTION =====");

        CarClass carClass = new CarClass();

        carClass.display();
        carClass.show();
        carClass.run();
        carClass.run2();

        BikeClass bikeClass = new BikeClass();

        bikeClass.display();
        bikeClass.show();
    }
}