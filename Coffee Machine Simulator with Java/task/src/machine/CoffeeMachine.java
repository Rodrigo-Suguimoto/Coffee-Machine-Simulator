package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterStock = scanner.nextInt();
        int cupsOfCoffeeWithWaterStock = waterStock / 200;

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkStock = scanner.nextInt();
        int cupsOfCoffeeWithMilkStock = milkStock / 50;

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansStock = scanner.nextInt();
        int cupsOfCoffeeWithCoffeeBeansStock = coffeeBeansStock / 15;

        // The maximum amount of cups of coffee
        int maxCupsOfCoffee = minBetweenThree(cupsOfCoffeeWithWaterStock,
                cupsOfCoffeeWithMilkStock,
                cupsOfCoffeeWithCoffeeBeansStock);

        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();
        if (cupsOfCoffee == maxCupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsOfCoffee < maxCupsOfCoffee) {
            int additionalCupsOfCoffee = maxCupsOfCoffee - cupsOfCoffee;
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", additionalCupsOfCoffee);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", maxCupsOfCoffee);
        }
    }

    private static int minBetweenThree(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
