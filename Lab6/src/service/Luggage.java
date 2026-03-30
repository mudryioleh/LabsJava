package service;

public class Luggage {
    private int itemCount;
    private int enteredItems;
    private double totalWeight;

    public void inputItemCount(int itemCount) {
        this.itemCount = itemCount;
        this.enteredItems = 0;
        this.totalWeight = 0.0;
    }

    public void inputItemWeight(double weight) {
        totalWeight += weight;
        enteredItems++;
    }

    public String printTotalWeight() {
        return "Загальна вага багажу: " + totalWeight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}