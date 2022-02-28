package info.toronto22.how_to_assert_two_objects_with_assertj.model;

public class User {
    String name;
    int age;
    Boolean isMarriage;
    double salary;

    public User(String name, int age, Boolean isMarriage, double salary) {
        this.name = name;
        this.age = age;
        this.isMarriage = isMarriage;
        this.salary = salary;
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

    public Boolean getMarriage() {
        return isMarriage;
    }

    public void setMarriage(Boolean marriage) {
        isMarriage = marriage;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
