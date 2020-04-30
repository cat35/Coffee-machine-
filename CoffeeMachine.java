package machine;
import java.util.Scanner;
public class CoffeeMachine {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
        calculate();
    }

    public static void calculate(){
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();
        int water = cups * 200;
        int milk = cups * 50;
        int coffee = cups * 15;
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
    }
}
