import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VandingMachine {
    private static List<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public  static void fillList(){
        for (int i = 0; i < 4; i++) {
            products.add(new Product(i));
        }
    }
    public static void print(){
        System.out.println("+------------------+---------+\n"+
                "|        Name      |   Price |");


        for (Product product : products) {

            System.out.printf("| %-16s | %-7s |%n", product.getName(),
                    product.getPrice());
        }
        System.out.println("+------------------+---------+");
    }
    public static void cash(){

        System.out.print("Please put your money: ");
        int cash = sc.nextInt();

        System.out.println("What do you want to do?");
        System.out.println("1) Add more money\n" +
                "2) Buy: ");
        var checked = products.stream()
                .filter(m -> m.getPrice()<=cash)
                .collect(Collectors.toList());
        checked.forEach(System.out::println);
        System.out.println("3) quit");
        int choise = sc.nextInt();
        switch (choise){
            case 1:
                System.out.print("Please add the money: ");
                int moreCash = sc.nextInt();
                moreCash = moreCash + cash;
                int finalMoreCash = moreCash;
                System.out.println(finalMoreCash);
               var available = products.stream()
                       .filter(n -> n.getPrice()<=finalMoreCash)
                       .collect(Collectors.toList());
               available.forEach(System.out::println);
                System.out.print("choose the product: ");
            case 2:
                System.out.print("choose the product: ");
                System.out.println(checked.get(0));
            case 3:
                System.out.println("take your money: " + cash);
                break;
        }

    }
}
