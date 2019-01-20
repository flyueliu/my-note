package Demo2;

import java.util.Date;

public class Person {

    private int age;
    private String name;
    private double salary;

    private Date date;

    public int getAge() {
	return age;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public double getSalary() {
	return salary;
    }

    public void setSalary(double salary) {
	this.salary = salary;
    }

    @Override
    public String toString() {
	return "Person [age=" + age + ", name=" + name + ", salary=" + salary + ", date=" + date + "]";
    }

}
