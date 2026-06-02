import java.util.Scanner;

public class Initial {
    public static void main(String[] args) {

        // Declare two integer variables
        int a, b;

        // Create Scanner object to take input from the user
        Scanner input = new Scanner(System.in);

        // Read first integer input
        a = input.nextInt();

        // Read second integer input
        b = input.nextInt();


        // Check if both numbers are equal
        if (a == b) {
            System.out.println("Duplicate numbers");
        } else {
            System.out.println("not Duplicate numbers");
        }

        // Switch statement to check the value of b
        switch (b) {
            case 1:
                System.out.println("First number");
                break;

            case 2:
                System.out.println("Second number");
                break;

            default:
                System.out.println("Invalid number");
                break;
        }

        // Calculate the sum of a and b
        int result = a + b;

        // Counter variable for loop
        int i = 0;

        // Infinite loop
        while (true) {

            // Print the result
            System.out.println(result);

            // Increment counter
            i++;

            // Exit loop after printing 10 times
            if (i == 10) {
                break;
            }
        }

        // Close the Scanner to free system resources
         input.close();
    }
}