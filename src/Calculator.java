import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        for(;;) {

            System.out.println("\n===== Calculator =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String op = input.nextLine().trim();

            if (op.equals("5")) {
                System.out.println("Exiting...");
                break;
            }

            if (!op.matches("[1-4]")) {
                System.out.println("Invalid option.");
                continue;
            }

            double a;
            double b;

            try {
                System.out.print("Enter first number: ");
                a = Double.parseDouble(input.nextLine());

                System.out.print("Enter second number: ");
                b = Double.parseDouble(input.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numbers.");
                continue;
            }

            switch (op) {

                case "1":
                    System.out.println("Result = " + (a + b));
                    break;

                case "2":
                    System.out.println("Result = " + (a - b));
                    break;

                case "3":
                    System.out.println("Result = " + (a * b));
                    break;

                case "4":
                    if (b == 0) {
                        System.out.println("Division by zero is not allowed.");
                    } else {
                        System.out.println("Result = " + (a / b));
                    }
                    break;
            }
        }

        input.close();
    }
}