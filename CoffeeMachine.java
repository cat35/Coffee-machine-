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
        calculateAmount();
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

    public static void calculateAmount(){
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterMl = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkMl = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeG = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int amountcups = sc.nextInt();

        int water = waterMl / 200;
        int milk = milkMl / 50;
        int coffee = coffeeG / 15;

        int limit = Math.min(water, Math.min(milk, coffee));

        if (amountcups > limit) {
            System.out.println("No, I can make only " + limit + " cup(s) of coffee");
        } else if (amountcups == limit) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            int extra = limit - amountcups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that)");
        }
    }
}
