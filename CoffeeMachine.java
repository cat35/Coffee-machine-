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
        print(water, milk, coffee, disposableCups, money);
        action(water, milk, coffee, disposableCups, money);
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
    public static void print(int water, int milk, int coffee, int disposableCups, int money) {


        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void action(int water, int milk, int coffee, int disposableCups, int money) {
        System.out.println("Write action (buy, fill, take):");
        String action = sc.nextLine();
        switch (action) {
            case "buy":
                buy(water, milk, coffee, disposableCups, money);
                break;
            case "fill":
                fill(water, milk, coffee, disposableCups, money);
                break;
            case "take":
                take(water, milk, coffee, disposableCups, money);
                break;

            default:
                break;
        }


    }

    public static void buy(int water, int milk, int coffee, int disposableCups, int money) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                water -= 250;
                coffee -= 16;
                disposableCups -= 1;
                money += 4;
                print(water, milk, coffee, disposableCups, money);
                break;

            case 2:
                water -= 350;
                milk -= 75;
                coffee -= 20;
                disposableCups -= 1;
                money += 7;
                print(water, milk, coffee, disposableCups, money);
                break;

            case 3:
                water -= 200;
                milk -= 100;
                coffee -= 12;
                disposableCups -= 1;
                money += 6;
                print(water, milk, coffee, disposableCups, money);
                break;

            default:
                break;
        }
    }

    public static void fill(int water, int milk, int coffee, int disposableCups, int money) {
        System.out.println("Write how many ml of water do you want to add: ");
        int addWater = sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int addMilk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int addCoffee = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int addDisposableCups = sc.nextInt();

        water += addWater;
        milk += addMilk;
        coffee += addCoffee;
        disposableCups += addDisposableCups;
        print(water, milk, coffee, disposableCups, money);

    }

    public static void take(int water, int milk, int coffee, int disposableCups, int money){

        System.out.println("I gave you $550");
        money = 0;
        print(water, milk, coffee, disposableCups, money);
    }
}
