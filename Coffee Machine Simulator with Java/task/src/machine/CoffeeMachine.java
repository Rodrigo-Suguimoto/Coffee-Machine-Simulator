package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();
        System.out.printf("For %d of coffee you will need:\n", cupsOfCoffee);

        int waterNeeded = cupsOfCoffee * 200;
        int milkNeeded = cupsOfCoffee * 50;
        int coffeeBeansNeeded = cupsOfCoffee * 15;

        System.out.printf("%d ml of water\n", waterNeeded);
        System.out.printf("%d ml of milk\n", milkNeeded);
        System.out.printf("%d g of coffee beans\n", coffeeBeansNeeded);
    }

}
