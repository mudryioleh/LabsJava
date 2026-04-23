package Taxi;
public class Driver {
    private String name;
    private int age;
    private int experienceYears;

    public Driver() {
    }

    public Driver(String name, int age, int experienceYears) {
        this.name = name;
        this.age = age;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void addExperienceYears(int delta) {
        this.experienceYears += delta;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
