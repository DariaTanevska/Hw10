package hw_10;

import java.util.Random;
import java.util.Scanner;

/*Создать метод, в котором создается одномерный массив типа int произвольного размера от 1 до 30, в котором каждому элементу массива присваивается произвольное значение от 0 до 30. Данный метод спрашивает у пользователя ввести с клавиатуры индекс случайно сгенерированного массива. Метод возвращает значение типа double, которое получается при делении элемента с указанным индексом пользователя на первый элемент данного массива.

   Продумать все возможные исключительные ситуации, которые могут возникнуть в данном методе. Для каждой исключительной ситуации создать собственный класс checked исключения. Прописать в методе условия генерации данных исключений, а также указать их в сигнатуре данного метода.

   Обработку исключения осуществить в сторонеем классе Main в котором нужно вызвать данный метод.*/
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

class ArrayGenerator {
    public static double generateAndDivide() throws CustomException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random array size between 1 and 30
        int arraySize = random.nextInt(30) + 1;
        int[] randomArray = new int[arraySize];

        // Fill the array with random values between 0 and 30
        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = random.nextInt(31);
        }

        // Ask the user for an index
        System.out.print("Enter an index (0 to " + (arraySize - 1) + "): ");
        int userIndex = scanner.nextInt();

        // Validate user input
        if (userIndex < 0 || userIndex >= arraySize) {
            throw new CustomException("Invalid index. Please enter a valid index.");
        }

        // Calculate the result
        double result = (double) randomArray[userIndex] / randomArray[0];
        return result;
    }
}

