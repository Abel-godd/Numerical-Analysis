import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x0 = getInput(scanner, "Enter the center point (x0): ");
        int n = getIntegerInput(scanner, "Enter the number of terms (n): ");
        double x = getInput(scanner, "Enter the point to evaluate (x): ");

        double result = taylorSeries(x0, n, x);
        System.out.println("Taylor series approximation: " + result);

        scanner.close(); // Close the scanner after use
    }

    private static double getInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static int getIntegerInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static double taylorSeries(double x0, int n, double x) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result += (Math.pow(-1, i) * Math.pow(x - x0, 2 * i)) / factorial(2 * i);
        }
        return result;
    }

    public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}