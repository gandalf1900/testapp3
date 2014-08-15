package no.web.domain;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person() {}

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setFirstName(String fname) {
        this.firstName = fname;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return new StringBuffer(" First Name : ").append(this.firstName).append("\n").append(" Last Name : ").append(this.lastName).append("\n").append(" Age : ").append(this.age).toString();
    }
}