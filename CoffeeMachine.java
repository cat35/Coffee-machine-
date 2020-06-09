package simpleRelisation;


public class CoffeeMachine {
    int water;
    int milk;
    int coffeeBeans;
    int disposableCups;
    int money;
    String input;
    State state = State.WORKING;


    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }


    public State getState() {
        return this.state;
    }

    void start() {
        working();
    }

    void working() {
        this.state = State.WORKING;
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit): ");


    }

    void inputString(String input) {
        this.input = input;

        switch (this.state) {
            case WORKING:
                System.out.println();
                switch (input) {
                    case "buy":
                        buy();
                        break;
                    case "take":
                        take();
                        break;
                    case "fill":
                        fill();
                        break;
                    case "remaining":
                        printRemaining();
                        break;
                    case "exit":
                        System.out.println("Goodbye");
                        state = State.OFF;
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
                break;
            case FILLING_WATER:
            case FILLING_MILK:
            case FILLING_CUPS:
            case FILLING_BEANS:
                fill();
                break;
            case BUYING:
                buy();
                break;
            default:
                break;
        }
    }

    public void buy() {

        switch (this.state) {
            case WORKING:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                this.state = State.BUYING;
                break;
            case BUYING:
                boolean remain = remaining(this.input);
                switch (this.input) {
                    case "1":
                        if (remain) {
                            this.water -= 250;
                            this.coffeeBeans -= 16;
                            this.disposableCups -= 1;
                            this.money += 4;

                        }
                        break;

                    case "2":
                        if (remain) {
                            this.water -= 350;
                            this.milk -= 75;
                            this.coffeeBeans -= 20;
                            this.disposableCups -= 1;
                            this.money += 7;

                        }
                        break;

                    case "3":
                        if (remain) {
                            this.water -= 200;
                            this.milk -= 100;
                            this.coffeeBeans -= 12;
                            this.disposableCups -= 1;
                            this.money += 6;

                        }
                        break;
                    case "back":
                        break;

                    default:
                        System.out.println("Unknown command for buying");
                        break;
                }
                working();
                break;
        }
    }


    public void printRemaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.coffeeBeans + " of coffee beans");
        System.out.println(this.disposableCups + " of disposable cups");
        System.out.println(this.money + " of money");
        working();
    }

    public void fill() {
        try {
            switch (this.state) {
                case WORKING:
                    System.out.println("Write how many ml of water do you want to add: ");
                    this.state = State.FILLING_WATER;
                    break;
                case FILLING_WATER:
                    this.water += Integer.parseInt(this.input);
                    System.out.println("Write how many ml of milk do you want to add: ");
                    this.state = State.FILLING_MILK;
                    break;
                case FILLING_MILK:
                    this.milk += Integer.parseInt(this.input);
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    this.state = State.FILLING_BEANS;
                    break;
                case FILLING_BEANS:
                    this.coffeeBeans += Integer.parseInt(this.input);
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    this.state = State.FILLING_CUPS;
                    break;
                case FILLING_CUPS:
                    this.disposableCups += Integer.parseInt(this.input);
                    working();
                    break;
                default:
                    working();
                    break;
            }
        } catch (NumberFormatException e) {

        }

    }

    public void take() {
        System.out.println("I gave you $ " + this.money);
        this.money = 0;
        working();
    }

    public boolean remaining(String coffeeType) {
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
        if (this.water < limitOfWater) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < limitOfMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeans < limitOfBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            remain = true;
            System.out.println("I have enough resources, making you a coffee!");
        }

        return remain;
    }
}