package simpleRelisation;


import java.util.Scanner;

import static simpleRelisation.State.OFF;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.start();
        while(coffeeMachine.getState() != OFF){
            coffeeMachine.inputString(sc.next());
        }

    }
}
