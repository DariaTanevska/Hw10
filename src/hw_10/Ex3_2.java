package hw_10;

import java.util.Scanner;

public class Ex3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя отца: ");
        String fatherName = scanner.nextLine();

        System.out.print("Введите сумму в кармане отца: ");
        int pocketMoney = scanner.nextInt();

        Father father = new Father(fatherName, pocketMoney);

        try {
            father.buyProducts(ProductType.APPLE, 3, ProductType.MILK, 6);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}