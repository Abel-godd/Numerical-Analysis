import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a function in the form 'a*e^(-b*t)' or 'a*t^n' (e.g., 5*e^(-2*t) or 3*t^2):");
        String function = scanner.nextLine();

        System.out.println("Enter the value for 's':");
        double s = scanner.nextDouble();

        try {
            double result = computeLaplaceTransform(function, s);
            System.out.println("The Laplace transform of the function is: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static double computeLaplaceTransform(String function, double s) throws Exception {
        // Basic parsing for function in the form of 'a*e^(-b*t)' or 'a*t^n'
        if (function.contains("e^")) {
            // Function is of the form 'a*e^(-b*t)'
            String[] parts = function.split("\\*e\\^");
            if (parts.length != 2) throw new Exception("Invalid function format.");
            
            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[1].replace("*t", "").replace(")", ""));
            
            // Laplace transform of a*e^(-b*t) is a / (s + b)
            return a / (s + b);
        } else if (function.contains("*t^")) {
            // Function is of the form 'a*t^n'
            String[] parts = function.split("\\*t\\^");
            if (parts.length != 2) throw new Exception("Invalid function format.");
            
            double a = Double.parseDouble(parts[0]);
            int n = Integer.parseInt(parts[1]);
            
            // Laplace transform of a*t^n is a / s^(n+1)
            return a / Math.pow(s, n + 1);
        } else {
            throw new Exception("Unsupported function format.");
        }
    }
}
