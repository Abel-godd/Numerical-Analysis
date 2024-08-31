public class Main {
    public static void main(String[] args) {
        double x0 = 0; // Center point
        int n = 10; // Number of terms
        double x = Math.PI / 3; // Point to evaluate
        double result = taylorSeries(x0, n, x);
        System.out.println("Taylor series approximation: " + result);
    }

    // Create the taylorSeries method
    public static double taylorSeries(double x0, int n, double x) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result += (Math.pow(-1, i) * Math.pow(x - x0, 2 * i)) / factorial(2 * i);
        }
        return result;
    }

    // Create the factorial method
    public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}