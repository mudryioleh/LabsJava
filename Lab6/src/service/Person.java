package service;

public class Person {
    private String fullName;
    private int age;

    public Person() {
        this.fullName = "Невідомо";
        this.age = 0;
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String move() {
        return fullName + " Person рухається";
    }

    public String talk() {
        return fullName + " Person говорить";
    }
}