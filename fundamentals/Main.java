// package fundamentals;

// public class Main{
//     public static void main(String[] args){
//         System.out.println(3 + 3);
//         System.out.println("Welcome to Java programming.");
//     }
// }

//======================data types================
// package fundamentals;
// public class Main {
//     public static void main(String[] args) {
//         String name = "Ngetich";
//         int age = 22;
//         boolean status = false;
//         System.out.println("Name: " + name + ", Age: " + age + ", Married: " + status);
//     }
// }

//====================Numbers==> bit, short,long, double, float
//------------type casting => converting one data type to another data type

// public class Main {
//     public static void main(String[] args) {
//         int num = 10;
//         double d = num; // implicit casting (widening)
//         System.out.println("Double value: " + d);
        
//         double pi = 3.14;
//         int intPi = (int) pi; // explicit casting (narrowing)
//         System.out.println("Integer value of pi: " + intPi);
//     }
// }

//============================if else statements
// public class Main{
//     public static void main(String[] args) {
//         int age = 20;
//         if (age >= 18) {
//             System.out.println("You are eligible to vote.");
//         } else {
//             System.out.println("You are not eligible to vote.");
//         }

//         // Nested if-else
//         if (age >= 18) {
//             if (age < 21) {
//                 System.out.println("You can vote but cannot drink alcohol.");
//             } else {
//                 System.out.println("You can vote and drink alcohol.");
//             }
//         } else {
//             System.out.println("You are too young to vote or drink alcohol.");
//         }
//     }
// }

//============================switch statements
// public class Main {
//     public static void main(String[] args) {
//         int day = 3;
//         switch (day) {
//             case 1:
//                 System.out.println("Monday");
//                 break;
//             case 2:
//                 System.out.println("Tuesday");
//                 break;
//             case 3:
//                 System.out.println("Wednesday");
//                 break;
//             case 4:
//                 System.out.println("Thursday");
//                 break;
//             case 5:
//                 System.out.println("Friday");
//                 break;
//             case 6:
//                 System.out.println("Saturday");
//                 break;
//             case 7:
//                 System.out.println("Sunday");
//                 break;
//             default:
//                 System.out.println("Invalid day");
//         }
//     }
// }

//============================loops
// public class Main {
//     public static void main(String[] args) {
//         // For loop
//         for (int i = 1; i <= 5; i++) {
//             System.out.println("For loop iteration: " + i);
//         }

//         // While loop
//         int j = 1;
//         while (j <= 5) {
//             System.out.println("While loop iteration: " + j);
//             j++;
//         }

//         // Do-while loop
//         int k = 1;
//         do {
//             System.out.println("Do-while loop iteration: " + k);
//             k++;
//         } while (k <= 5);
//     }
// }

//============================arrays
// public class Main {
//     public static void main(String[] args) {
//         // Declare and initialize an array
//         int[] numbers = {1, 2, 3, 4, 5};

//         // Accessing array elements
//         for (int i = 0; i < numbers.length; i++) {
//             System.out.println("Element at index " + i + ": " + numbers[i]);
//         }

//         // Enhanced for loop
//         for (int num : numbers) {
//             System.out.println("Number: " + num);
//         }
//     }
// }

//============================multidimensional arrays
// public class Main {
//     public static void main(String[] args) {
//         // Declare and initialize a 2D array
//         int[][] matrix = {
//             {1, 2, 3},
//             {4, 5, 6},
//             {7, 8, 9}
//         };

//         // Accessing elements in a 2D array
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 System.out.print(matrix[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

//============================methods
// public class Main {
//     public static void main(String[] args) {
//         // Calling a method
//         int sum = add(5, 10);
//         System.out.println("Sum: " + sum);

//         // Calling a method with no return value
//         greet("Ngetich");
//     }

//     // Method that returns an integer
//     public static int add(int a, int b) {
//         return a + b;
//     }

//     // Method with no return value
//     public static void greet(String name) {
//         System.out.println("Hello, " + name + "!");
//     }
// }
//============================classes and objects

// public class Main {
//     public static void main(String[] args) {
//         // Creating an object of the Person class
//         Person person = new Person("Ngetich", 22);
//         person.introduce();
//     }
// }

// // Definition of the Person class
// class Person {
//     private String name;
//     private int age;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     public void introduce() {
//         System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
//     }
// }

//============================inheritance
// public class Main {
//     public static void main(String[] args) {
//         // Creating an object of the Student class
//         Student student = new Student("Ngetich", 22, "Computer Science");
//         student.introduce();
//     }
// }

// class Person {
//     private String name;
//     private int age;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     public void introduce() {
//         System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
//     }
// }

// class Student extends Person {
//     private String major;

//     public Student(String name, int age, String major) {
//         super(name, age); // Call the constructor of the superclass (Person)
//         this.major = major;
//     }

//     @Override
//     public void introduce() {
//         super.introduce(); // Call the introduce method of the superclass
//         System.out.println("I am studying " + major + ".");
//     }
// }

//============================polymorphism
// public class Main {
//     public static void main(String[] args) {
//         Animal myDog = new Dog();
//         Animal myCat = new Cat();

//         myDog.makeSound(); // Outputs: Woof
//         myCat.makeSound(); // Outputs: Meow
//     }
// }
// class Animal {
//     public void makeSound() {
//         System.out.println("Some generic animal sound");
//     }
// }
// class Dog extends Animal {
//     @Override
//     public void makeSound() {
//         System.out.println("Woof");
//     }
// }
// class Cat extends Animal {
//     @Override
//     public void makeSound() {
//         System.out.println("Meow");
//     }
// }

//============================encapsulation
// public class Main {
//     public static void main(String[] args) {
//         Person person = new Person("Ngetich", 22);
//         System.out.println("Name: " + person.getName());
//         System.out.println("Age: " + person.getAge());

//         // Attempting to set an invalid age
//         person.setAge(-5); // This will not change the age
//         System.out.println("Updated Age: " + person.getAge());
//     }
// }
// class Person {
//     private String name;
//     private int age;

//     public Person(String name, int age) {
//         this.name = name;
//         setAge(age); // Use setter to validate age
//     }

//     public String getName() {
//         return name;
//     }

//     public int getAge() {
//         return age;
//     }

//     public void setAge(int age) {
//         if (age >= 0) { // Validate age
//             this.age = age;
//         } else {
//             System.out.println("Invalid age. Age must be non-negative.");
//         }
//     }
// }

//============================abstraction
// public class Main {
//     public static void main(String[] args) {
//         Shape circle = new Circle(5);
//         Shape rectangle = new Rectangle(4, 6);

//         System.out.println("Circle area: " + circle.calculateArea());
//         System.out.println("Rectangle area: " + rectangle.calculateArea());
//     }
// }
// abstract class Shape {
//     public abstract double calculateArea();
// }
// class Circle extends Shape {
//     private double radius;

//     public Circle(double radius) {
//         this.radius = radius;
//     }

//     @Override
//     public double calculateArea() {
//         return Math.PI * radius * radius;
//     }
// }
// class Rectangle extends Shape {
//     private double width;
//     private double height;

//     public Rectangle(double width, double height) {
//         this.width = width;
//         this.height = height;
//     }

//     @Override
//     public double calculateArea() {
//         return width * height;
//     }
// }

//============================interfaces - a contract that a class can implement
public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.start();
        bike.start();
    }
}
interface Vehicle {
    void start(); // Abstract method
}
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }
}
class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }
}

// Note: The above code demonstrates the use of interfaces in Java.
// Classes Car and Bike implement the Vehicle interface, providing their own implementations of the start method.
// This allows for polymorphism, where we can treat different types of vehicles uniformly.
// Interfaces are a powerful feature in Java that allow for abstraction and multiple inheritance.
// They enable you to define methods that must be implemented by any class that chooses to implement the interface.
// This promotes a clean separation of concerns and enhances code reusability.
// Interfaces can also extend other interfaces, allowing for more complex hierarchies and behaviors.
// Interfaces are commonly used in Java frameworks and libraries, such as the Java Collections Framework,
// where they define contracts for collections like List, Set, and Map.
// This code can be run in a Java environment to see the output of the interface implementations.
// The output will show the starting messages for both the Car and Bike classes.

