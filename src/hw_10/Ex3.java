package hw_10;
/*Реализовать данную ситуацию в коде.

• Отцу у которого есть имя и определенная сумма в кармане должен сходить в магазин.
        • В магазине есть 5 типов продуктов: яблоко, картошка, молоко, пиво и табак.
• У каждого товара есть своя цена.
        • Отцу необходимо сделать покупку, максимум он может купить только два типа продуктов.
• Но любой тип продуктов может быть куплен в любом количестве.
Т.е. он может купить только молоко. Или купить 3 молока, и 2 яблока. Но он не может купить яблоко, три пива и две картофелины. Неприятная ситуация произойдет в нескольких ситуациях:

Если сумма покупки превышает количество денег в кармане отца.
Если он принесет домой пиво либо табак.
Если количество хотябы одного из купленных товаров не будет делиться на три. (т.е. он не сможет поровну разделить купленный продукт между собой, женой и ребенком)
Реализовать данную ситуацию при помощи объектно ориентированного подхода. Постараться использовать перечислительный тип данных Enum. А также исключения. Постараться обработать все исключения в стороннем методе, а не в теле метода созданного у отца.

В случае если отцу удасться избежать неприятной ситуации на консоль должно вывестись сообщение примерно такого типа:

Уважаемый Валентин стоимость ваших покупок 150. Вы приобрели APPLE в количестве 3, и MILK в количестве 6*/
enum ProductType {
    APPLE(10),
    POTATO(5),
    MILK(20),
    BEER(30),
    TOBACCO(40);

    private final int price;

    ProductType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Father {
    private final String name;
    private int pocketMoney;

    public Father(String name, int pocketMoney) {
        this.name = name;
        this.pocketMoney = pocketMoney;
    }

    public void buyProducts(ProductType product1, int quantity1, ProductType product2, int quantity2) throws Exception {
        int totalCost = product1.getPrice() * quantity1 + product2.getPrice() * quantity2;

        if (totalCost > pocketMoney) {
            throw new Exception("Not enough money to make the purchase.");
        }

        if (product1 == ProductType.BEER || product1 == ProductType.TOBACCO ||
                product2 == ProductType.BEER || product2 == ProductType.TOBACCO) {
            throw new Exception("Cannot buy beer or tobacco.");
        }

        if (quantity1 % 3 != 0 || quantity2 % 3 != 0) {
            throw new Exception("Quantity of products must be divisible by 3.");
        }

        pocketMoney -= totalCost;
        System.out.println("Уважаемый " + name + ", стоимость ваших покупок " + totalCost +
                ". Вы приобрели " + product1 + " в количестве " + quantity1 +
                ", и " + product2 + " в количестве " + quantity2);
    }
}
