package machine;

import java.util.Scanner;

public class CoffeeMachine {

    int waterStock;
    int milkStock;
    int coffeeBeansStock;
    int disposableCups;
    int money;

    public CoffeeMachine(int waterStock, int milkStock, int coffeeBeansStock, int disposableCups, int money) {
        this.waterStock = waterStock;
        this.milkStock = milkStock;
        this.coffeeBeansStock = coffeeBeansStock;
        this.disposableCups = disposableCups;
        this.money = money;
    }
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540,
                120, 9, 550);
        coffeeMachine.printCoffeeState();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take):");
        String option = scanner.next();
        switch (option) {
            case "buy":
                coffeeMachine.buyCoffee(scanner);
                break;
            case "fill":
                coffeeMachine.fillMachine(scanner);
                break;
            case "take":
                coffeeMachine.takeMoney();
                break;
        }
    }

    public void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                this.waterStock -= 250;
                this.coffeeBeansStock -= 16;
                this.disposableCups -= 1;
                this.money += 4;
                break;
            case 2:
                this.waterStock -= 350;
                this.milkStock -= 75;
                this.coffeeBeansStock -= 20;
                this.disposableCups -= 1;
                this.money += 7;
                break;
            case 3:
                this.waterStock -= 200;
                this.milkStock -= 100;
                this.coffeeBeansStock -= 12;
                this.disposableCups -= 1;
                this.money += 6;
                break;
        }
        printCoffeeState();
    }

    public void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        this.waterStock += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        this.milkStock += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeansStock += scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        this.disposableCups += scanner.nextInt();

        printCoffeeState();
    }

    public void takeMoney() {
        System.out.printf("I gave you $%d\n\n", this.money);
        this.money = 0;
        printCoffeeState();
    }

    public void printCoffeeState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", this.waterStock);
        System.out.printf("%d ml of milk\n", this.milkStock);
        System.out.printf("%d g of coffee beans\n", this.coffeeBeansStock);
        System.out.printf("%d disposable cups\n", this.disposableCups);
        System.out.printf("$%d of money\n\n", this.money);
    }

}
