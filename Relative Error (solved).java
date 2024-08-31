public class Main {
    public static void main(String[] args) {
        double actualValue = 10.0; // Actual value
        double approximatedValue = 9.9; // Approximated value

        double relativeError = calculateRelativeError(actualValue, approximatedValue);
        System.out.println("Relative error: " + relativeError);
    }

    public static double calculateRelativeError(double actualValue, double approximatedValue) {
        if (actualValue == 0) {
            throw new ArithmeticException("Actual value cannot be zero");
        }

        double absoluteError = Math.abs(actualValue - approximatedValue);
        double relativeError = absoluteError / Math.abs(actualValue);

        return relativeError;
    }
}