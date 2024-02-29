package hw_10;

public class Ex2_2 {
    public static void main(String[] args) {
        try {
            double result = ArrayGenerator.generateAndDivide();
            System.out.println("Result: " + result);
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}