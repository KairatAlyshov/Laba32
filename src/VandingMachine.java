import java.util.ArrayList;
import java.util.List;

public class VandingMachine {
    private static List<Product> products = new ArrayList<>();

    public  static void fillList(){
        for (int i = 0; i < 4; i++) {
            products.add(new Product(i));
        }
    }
    public static void print(){
        System.out.println("---+---------------+---------+\n"+
                " # |      name     |   Price |");
        int number = 0;

        for (Product product : products) {
            number++;
            System.out.printf(" %s | %-13s | %-7s |%n", number, product.getName(),
                    product.getPrice());
        }
        System.out.println("---+---------------+---------+");

    }
}
