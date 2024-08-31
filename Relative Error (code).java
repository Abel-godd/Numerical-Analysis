import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user for the actual value
            System.out.print("Enter the actual value: ");
            double actualValue = scanner.nextDouble();

            // Prompt user for the measured value
            System.out.print("Enter the measured value: ");
            double measuredValue = scanner.nextDouble();

            // Calculate the relative error
            double relativeError = calculateRelativeError(actualValue, measuredValue);

            // Print the result
            System.out.printf("Relative Error: %.2f%%\n", relativeError * 100);
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid numbers.");
        } finally {
            // Close the scanner
            scanner.close();
        }
    }

    /**
     * Calculates the relative error between actual and measured values.
     * 
     * @param actualValue The actual value
     * @param measuredValue The measured value
     * @return The relative error as a fraction
     */
    private static double calculateRelativeError(double actualValue, double measuredValue) {
        if (actualValue == 0) {
            throw new ArithmeticException("Actual value cannot be zero.");
        }
        return Math.abs((measuredValue - actualValue) / actualValue);
    }
}
