package machine;
import java.util.Scanner;
public class CoffeeMachine {
   package machine;

import java.util.Scanner;

    public class CoffeeMachine {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int water = 400;
            int milk = 540;
            int coffee = 120;
            int disposableCups = 9;
            int money = 550;


            while (true) {
                System.out.println("Write action (buy, fill, take remaining, exit): ");
                String action = sc.next();
                switch (action) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                        String choice = sc.next();
                        boolean remain = remaining(choice, water, milk, coffee, disposableCups);
                        switch (choice) {
                            case "1":
                                if (remain) {
                                    water -= 250;
                                    coffee -= 16;
                                    disposableCups -= 1;
                                    money += 4;

                                }
                                break;


                            case "2":
                                if (remain) {
                                    water -= 350;
                                    milk -= 75;
                                    coffee -= 20;
                                    disposableCups -= 1;
                                    money += 7;

                                }
                                break;

                            case "3":
                                if (remain) {
                                    water -= 200;
                                    milk -= 100;
                                    coffee -= 12;
                                    disposableCups -= 1;
                                    money += 6;

                                }
                                break;

                            case "back":
                                break;

                            default:
                                System.out.println("Please, pick other coffee");
                                break;
                        }
                        break;
                    case "fill":
                        System.out.println("Write how many ml of water do you want to add: ");
                        water += sc.nextInt();
                        System.out.println("Write how many ml of milk do you want to add: ");
                        milk += sc.nextInt();
                        System.out.println("Write how many grams of coffee beans do you want to add: ");
                        coffee += sc.nextInt();
                        System.out.println("Write how many disposable cups of coffee do you want to add: ");
                        disposableCups += sc.nextInt();



                        break;
                    case "take":
                        System.out.println("I gave you $ " + money);
                        money = 0;

                        break;
                    case "remaining":
                        print(water, milk, coffee, disposableCups, money);
                        break;
                    case "exit":
                        return;

                    default:
                        System.out.println("Unknown action");
                        break;


                }



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



        public static boolean remaining(String coffeeType, int water, int milk, int coffee, int disposableCups) {
            boolean remain = false;
            int limitOfWater;
            int limitOfMilk;
            int limitOfBeans;

            switch (coffeeType) {
                case "1":
                    limitOfWater = 250;
                    limitOfMilk = 0;
                    limitOfBeans = 16;
                    break;
                case "2":
                    limitOfWater = 350;
                    limitOfMilk = 75;
                    limitOfBeans = 20;
                    break;
                case "3":
                    limitOfWater = 200;
                    limitOfMilk = 100;
                    limitOfBeans = 12;
                    break;
                default:
                    return false;
            }
            if (water < limitOfWater) {
                System.out.println("Sorry, not enough water!");
            } else if (milk < limitOfMilk) {
                System.out.println("Sorry, not enough milk!");
            } else if (coffee < limitOfBeans) {
                System.out.println("Sorry, not enough coffee beans!");
            } else if (disposableCups < 1) {
                System.out.println("Sorry, not enough disposable cups!");
            } else {
                remain = true;
                System.out.println("I have enough resources, making you a coffee!");
            }

            return remain;
        }
    }