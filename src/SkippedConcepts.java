public class SkippedConcepts {

    public static void main(String[] args) {

        // Creating an object using constructor
        Student stud = new Student("Kushal", "Harsora", 23);

        // Encapsulation: accessing private data through getter
        String firstName = stud.getFirstName();

        // Encapsulation: modifying private data through setter
        int id = 101;
        stud.setId(id);

        // Static method call using class name
        Student.calculateAge(10);

        System.out.println("First Name: " + firstName);
        System.out.println("Student ID: " + stud.getId());

        CalculatorTest calc = new CalculatorTest();

        int division = calc.divide(10, 2);
        System.out.println("Division: " + division);

        // Uncomment to test exception handling
        // int divisionByZero = calc.divide(10, 0);
        // System.out.println("Division: " + divisionByZero);
    }
}

class Student {

    // Private variables support Encapsulation
    private String firstName;
    private String lastName;
    private int age;
    private int id;

    /*
     * final variable:
     * Once initialized, its value cannot be changed.
     * Every student must have minimum age = 18.
     */
    public final int minAge;

    // Constructor
    Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        // final variable must be initialized
        this.minAge = 18;
    }

    /*
     * static method:
     * Belongs to the class rather than object.
     * Can be called using Student.calculateAge(...)
     */
    public static void calculateAge(int age) {

        try {
            if (age >= 18) {
                System.out.println("Valid Age");
            } else {
                // Throwing custom exception
                throw new IllegalArgumentException(
                        "Age must be 18 or above.");
            }

        } catch (IllegalArgumentException e) {

            /*
             * Exception Handling:
             * Prevents program from crashing and
             * allows graceful error handling.
             */
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // -------------------------
    // Encapsulation using Setters
    // -------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // -------------------------
    // Encapsulation using Getters
    // -------------------------

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}

class CalculatorTest {

    public int sum(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {

        try {

            // May throw ArithmeticException if b = 0
            return a / b;

        } catch (ArithmeticException e) {

            System.out.println("Error: Division by zero is not allowed.");
            return -1;

        } finally {

            /*
             * finally block:
             * Executes whether exception occurs or not.
             * Usually used for cleanup operations.
             */
            System.out.println("Finally block executed.");
        }
    }
}