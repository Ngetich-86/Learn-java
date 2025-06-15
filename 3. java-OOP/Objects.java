// decided to make this understandable using a car case study 🚗 to illustrate the concepts of OOP in Java.

//  ++++++++++===========================================inheritance → Reusing code ++++++++++
// - Inheritance allows a class (child/subclass) to inherit properties and behaviors (methods) from another class (parent/superclass).
// - This promotes code reusability and establishes a hierarchical relationship between classes.
// - Example: A `Car` class can inherit from a `Vehicle` class, gaining its properties like `speed` and methods like `start()`.

class Vehicle {
    public void start() {
        System.out.println("Vehicle 🚗 is starting");
    }
}
class ferrari extends Vehicle {
    public void startRacing() {
        System.out.println("Ferrari 🚗 is starting with a roar!");
    }
}
// Now Car inherits start() from Vehicle, no need to rewrite it → promotes code reuse.
class Objects {
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle();
        myVehicle.start(); // Output: Vehicle 🚗 is starting

        ferrari myFerrari = new ferrari();
        myFerrari.start(); // Output: Vehicle 🚗 is starting
        myFerrari.startRacing(); // Output: Ferrari 🚗 is starting with a roar!
    }
}

//  ++++++++++encapsulation → Protecting data ++++++++++
// - Encapsulation is about bundling data (variables) and methods into a single unit (class), and restricting direct access to some parts of it.
class Car {
    private String engine;  // Private = hidden from outside

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngine() {
        return engine;
    }
}
// In this example, the `engine` variable is private, meaning it can’t be accessed directly from outside the class. Instead, we use public methods `setEngine()` and `getEngine()` to modify and retrieve its value.




//  ++++++++++polymorphism → One thing, many forms ++++++++++
// - Polymorphism allows different classes to define the same method in different ways.
class Vehicle {
    public void start() {
        System.out.println("Vehicle starting...");
    }
}
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car engine roaring to life...");
    }
}
//Same method start(), different behavior depending on whether it’s a Vehicle or a Car.




//  ++++++++++abstraction → Showing only what’s necessary++++++++++
// - Abstraction hides complex details and shows only essential features.
abstract class Vehicle {
    abstract void start();  // Abstract method → no body

    public void fuel() {
        System.out.println("Fuel added.");
    }
}
class Car extends Vehicle {
    public void start() {
        System.out.println("Car started with key.");
    }
}


//  ++++++++++Interfaces → Contract for behavior==========
//  - Interfaces define a contract for classes to implement specific behaviors without dictating how they should be implemented.

interface Drivable {
    void drive();
}
class car implements Drivable {
    @Override
    public void drive() {
        System.out.println("Car 🚗 is driving");
    }
}
// Now any class that implements Drivable  → standardizes behavior. must provide its own implementation of the drive() method.
class ObjectsWithInterface {
    public static void main(String[] args) {
        car myCar = new car();
        myCar.drive(); // Output: Car 🚗 is driving
    }
}

