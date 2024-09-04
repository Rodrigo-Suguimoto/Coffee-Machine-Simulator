package machine;

import java.util.Scanner;

public class CoffeeMachine {

    int waterStock;
    int milkStock;
    int coffeeBeansStock;
    int disposableCups;
    double money;

    public CoffeeMachine(int waterStock, int milkStock, int coffeeBeansStock, int disposableCups, double money) {
        this.waterStock = waterStock;
        this.milkStock = milkStock;
        this.coffeeBeansStock = coffeeBeansStock;
        this.disposableCups = disposableCups;
        this.money = money;
    }
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540,
                120, 9, 550);

        Scanner scanner = new Scanner(System.in);
        coffeeMachine.getUserInput(scanner, coffeeMachine);
    }

    public void getUserInput(Scanner scanner, CoffeeMachine coffeeMachine) {
        String option;
        do {
            System.out.println("Write action (buy, fill, take):");
            option = scanner.next();

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
                case "remaining":
                    coffeeMachine.printCoffeeMachineState();
                    break;
            }
        } while (!option.equals("exit"));
    }

    public void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String option = scanner.next();

        switch (option) {
            case "1":
                CoffeeRecipe espresso = CoffeeRecipe.ESPRESSO;
                if (areThereEnoughIngredients(espresso)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    makeEspresso();
                }
                break;
            case "2":
                CoffeeRecipe latte = CoffeeRecipe.LATTE;
                if (areThereEnoughIngredients(latte)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    makeLatte();
                }
                break;
            case "3":
                CoffeeRecipe cappuccino = CoffeeRecipe.CAPPUCCINO;
                if (areThereEnoughIngredients(cappuccino)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    makeCappuccino();
                }
                break;
            case "back":
                break;
        }
    }

    private void makeEspresso() {
        this.waterStock -= 250;
        this.coffeeBeansStock -= 16;
        this.disposableCups -= 1;
        this.money += 4;
    }

    private void makeLatte() {
        this.waterStock -= 350;
        this.milkStock -= 75;
        this.coffeeBeansStock -= 20;
        this.disposableCups -= 1;
        this.money += 7;
    }

    private void makeCappuccino() {
        this.waterStock -= 200;
        this.milkStock -= 100;
        this.coffeeBeansStock -= 12;
        this.disposableCups -= 1;
        this.money += 6;
    }

    private boolean areThereEnoughIngredients(CoffeeRecipe recipe) {
        if (!isThereEnoughWater(recipe.getWaterAmount())) {
            System.out.println("Sorry, not enough water!");
            return false;
        }

        if (recipe.getMilkAmount() != 0) {
            if (!isThereEnoughMilk(recipe.getMilkAmount())) {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        }

        if (!areThereEnoughCoffeeBeans(recipe.getCoffeeBeansAmount())) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        if (!areThereEnoughCups(recipe.getCupsAmount())) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        return true;
    }

    private boolean isThereEnoughWater(int water) {
        return this.waterStock / water != 0;
    }

    private boolean areThereEnoughCoffeeBeans(int coffeeBeans) {
        return this.coffeeBeansStock / coffeeBeans != 0;
    }

    private boolean isThereEnoughMilk(int milk) {
        return this.milkStock / milk != 0;
    }

    private boolean areThereEnoughCups(int cup) {
        return this.disposableCups / cup != 0;
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
    }

    public void takeMoney() {
        System.out.printf("I gave you $%.0f\n\n", this.money);
        this.money = 0;
    }

    public void printCoffeeMachineState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", this.waterStock);
        System.out.printf("%d ml of milk\n", this.milkStock);
        System.out.printf("%d g of coffee beans\n", this.coffeeBeansStock);
        System.out.printf("%d disposable cups\n", this.disposableCups);
        System.out.printf("$%.0f of money\n\n", this.money);
    }

}
