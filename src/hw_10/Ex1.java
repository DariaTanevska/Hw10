package hw_10;
/*Написать метод, который будет выводить на консоль информацию о названии магазина в котором происходит покупка, о стоимости данной покупки. Об имени продавца, который продает товар, об имени покупателя, который покупает товар, название товара и возраст покупателя.

• Продавец может быть честным или нет.
            • Если он честный и товар является алкогольным, то тогда он не продаст данный товар покупателю.
            • Если он нечестный и товар является алкогольным, то тогда он продаст данный товар покупателю.
• Если у покупателя имеется скидочная карта, то цена покупки будет снижена на 10 процентов.
• Все поля классов должны быть приватными.
            • Метод покупки принадлежит самому магазину.
• Свойство честности принадлежит только продавцу.
• Только покупатель может иметь скидочную карту.
    Также метод, который необходимо реализовать для решения данной задачи, должен имплементировать функциональный интерфейс с таким же методом.

    По итогу в классе Main должна быть прописана примерно такая логика:

    Shop shop = new Shop();
shop.returnCost();
    Конечно же с правильно заданными параметрами метода, и аргументами конструкторов.

    А на консоль должно выводиться сообщение примерно следующее:

    Уважаемый {Имя покупателя}, продавец {Имя продавца} нашего магазина “{Название магазина}”, продаст вам этот товар {Название товара}, в них есть алкогольная продукция, а ваш возраст {Возраст покупателя}. Стоимость вашей покупки равна {Стоимость покупки} Вот вам скидка

    P.s. Сообщение для вывода напишите такое, какое пожелаете. Это просто пример. Плюс оно должно меняться в зависимости от параметра объектов, которые будут приниматься в метод.
*/
interface Seller{
    boolean isHonest();

    String getName();
}
class Shop {
    private String shopNeme;
    public Shop(String shopNeme){
        this.shopNeme = shopNeme;
    }
    public void returnCost(Customer customer, Item item) {
        double basePrice = item.getPrice();
        double discountedPrice = customer.hasDiscountCard() ? basePrice * 0.9 : basePrice;

        String honesty = customer.getSeller().isHonest() ? "не продаст" : "продаст";
        String alcoholMessage = item.isAlcoholic() ? "в них есть алкогольная продукция" : "без алкоголя";

        System.out.println("Уважаемый " + customer.getName() + ", продавец " + customer.getSeller().getName() +
                " нашего магазина \"" + shopNeme + "\", " + honesty + " вам этот товар " + item.getName() +
                ", " + alcoholMessage + ", а ваш возраст " + customer.getAge() + ". Стоимость вашей покупки равна " +
                discountedPrice + " Вот вам скидка.");
    }
}

class Customer {
    private String name;
    private int age;
    private boolean hasDiscountCard;
    private Seller seller;

    public Customer(String name, int age, boolean hasDiscountCard, Seller seller) {
        this.name = name;
        this.age = age;
        this.hasDiscountCard = hasDiscountCard;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasDiscountCard() {
        return hasDiscountCard;
    }

    public Seller getSeller() {
        return seller;
    }
}

class Item {
    private String name;
    private double price;
    private boolean isAlcoholic;

    public Item(String name, double price, boolean isAlcoholic) {
        this.name = name;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }
}

class HonestSeller implements Seller {
    private String name;

    public HonestSeller(String name) {
        this.name = name;
    }

    @Override
    public boolean isHonest() {
        return true;
    }

    public String getName() {
        return name;
    }
}

class DishonestSeller implements Seller {
    private String name;

    public DishonestSeller(String name) {
        this.name = name;
    }

    @Override
    public boolean isHonest() {
        return false;
    }

    public String getName() {
        return name;
    }
}

