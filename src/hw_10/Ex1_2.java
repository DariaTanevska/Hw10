package hw_10;

public class Ex1_2 {
        public static void main(String[] args) {
            Shop shop = new Shop("SuperMart");

            Seller honestSeller = new HonestSeller("John");
            Seller dishonestSeller = new DishonestSeller("Mike");

            Customer customer1 = new Customer("Alice", 30, true, honestSeller);
            Customer customer2 = new Customer("Bob", 25, false, dishonestSeller);

            Item item1 = new Item("Wine", 50.0, true);
            Item item2 = new Item("Bread", 5.0, false);

            shop.returnCost(customer1, item1);
            shop.returnCost(customer2, item2);
        }
}
