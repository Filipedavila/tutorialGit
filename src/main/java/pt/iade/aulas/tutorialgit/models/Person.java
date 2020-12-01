package pt.iade.aulas.tutorialgit.models;

import java.time.LocalDate;

public abstract class Person {
    protected  String name;
    protected LocalDate birthDay;
    protected String email;
    protected char gender;

    public Person(String name, char gender, LocalDate birthDay) {
        this.name = name;
        this.email = "";
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public abstract String getReference();


}
