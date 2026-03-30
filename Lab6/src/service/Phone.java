package service;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone() {
        this.number = "Невідомо";
        this.model = "Невідомо";
        this.weight = 0.0;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 0.0;
    }

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public String receiveCall(String callerName) {
        return "Дзвонить " + callerName;
    }

    public String receiveCall(String callerName, String callerNumber) {
        return "Дзвонить " + callerName + " (" + callerNumber + ")";
    }

    public String sendMessage(String... numbers) {
        StringBuilder result = new StringBuilder("Відправляю повідомлення на номери:");
        for (String number : numbers) {
            result.append(System.lineSeparator()).append(number);
        }
        return result.toString();
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }
}