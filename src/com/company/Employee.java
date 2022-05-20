package com.company;

public class Employee {
    private static int counter;
    private int id;
    private String name;
    private String surname;
    private String patronymic;

    public Employee(String name, String surname, String patronymic, int department, float salary) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = counter;
        counter++;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    private int department;
    private float salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id= " + id +
                " surname= " + surname +
                " name= " + name +
                " patronymic= " + patronymic +
                " department= " + department +
                " salary= " + salary +
                '}';
    }
}
