package machine;

public enum CoffeeRecipe {
    ESPRESSO("Espresso", 250, 16, 1, 4),
    LATTE("Latte", 350, 20, 75, 1, 7),
    CAPPUCCINO("Cappuccino", 200, 12, 100, 1, 6);

    private final String name;
    private final int waterAmount;
    private final int coffeeBeansAmount;
    private final int milkAmount;
    private final int cupsAmount;
    private final double cost;

    CoffeeRecipe(String name, int waterAmount, int coffeeBeansAmount, int cupsAmount, double cost) {
        this(name, waterAmount, coffeeBeansAmount, 0, cupsAmount, cost);
    }

    CoffeeRecipe(String name, int waterAmount, int coffeeBeansAmount, int milkAmount, int cupsAmount, double cost) {
        this.name = name;
        this.waterAmount = waterAmount;
        this.coffeeBeansAmount = coffeeBeansAmount;
        this.milkAmount = milkAmount;
        this.cupsAmount = cupsAmount;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getCoffeeBeansAmount() {
        return coffeeBeansAmount;
    }

    public int getMilkAmount() {
        return milkAmount;
    }

    public int getCupsAmount() {
        return cupsAmount;
    }

    public double getCost() {
        return cost;
    }
}
