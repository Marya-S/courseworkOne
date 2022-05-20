package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private Employee[] employeeDB;

    public EmployeeBook() {
        employeeDB = new Employee[10];
        employeeDB[0] = new Employee("Иван", "Иванов", "Иванович", 1, 12570f);
        employeeDB[1] = new Employee("Петр", "Петров", "Петрович", 3, 25700f);
        employeeDB[2] = new Employee("Дмитрий", "Дмитроиенко", "Дмитриевич", 4, 21500f);
        employeeDB[3] = new Employee("Никита", "Никитин", "Иванович", 2, 10500f);
        employeeDB[4] = new Employee("Екатерина", "Романова", "Алексеевна", 5, 27500f);
        employeeDB[5] = new Employee("Фаина", "Раневская", "Георгиевна", 4, 17350.50f);
        employeeDB[6] = new Employee("Александр", "Пушкин", "Сергеевич", 2, 11500f);
        employeeDB[7] = new Employee("Николай", "Пирогов", "Иванович", 3, 27300f);
        employeeDB[8] = new Employee("Дмитрий", "Менделеев", "Иванович", 3, 25900f);
        employeeDB[9] = new Employee("Анна", "Павлова", "Матвеевна", 4, 24300f);
    }

    public void getAllEmployee() {
        for (Employee employee : employeeDB) {
            System.out.println(employee.toString());
        }
    }

    public float sumSalary() {
        float sum = 0;
        for (Employee employee : employeeDB) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee employeeWithMinSalary() {
        Employee employeeWithMinSalary = employeeDB[0];
        for (Employee employee : employeeDB) {
            if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee employeeWithMaxSalary() {
        Employee employeeWithMaxSalary = employeeDB[0];
        for (Employee employee : employeeDB) {
            if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public float avgSalary() {
        return sumSalary() / employeeDB.length;
    }

    public void printFio() {
        for (Employee employee : employeeDB) {
            System.out.println(String.join(" ", employee.getSurname(), employee.getName(), employee.getPatronymic()));
        }
    }

    public void indexSalary(int index) {
        for (Employee employee : employeeDB) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
        }
    }

    public Employee employeeWithMinSalaryInDepartment(int depart) {
        int i = 0;
        Employee employeeWithMinSalary;
        while (true) {
            if (employeeDB[i].getDepartment() == depart) {
                employeeWithMinSalary = employeeDB[i];
                break;
            }
            i++;
        }
        for (Employee employee : employeeDB) {
            if (employee.getDepartment() == depart && employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee employeeWithMaxSalaryInDepartment(int depart) {
        int i = 0;
        Employee employeeWithMaxSalary;
        while (true) {
            if (employeeDB[i].getDepartment() == depart) {
                employeeWithMaxSalary = employeeDB[i];
                break;
            }
            i++;
        }
        for (Employee employee : employeeDB) {
            if (employee.getDepartment() == depart && employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public float sumSalaryInDepartment(int depart) {
        float sum = 0;
        for (Employee employee : employeeDB) {
            if (employee.getDepartment() == depart) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public float avgSalaryInDepartment(int depart) {
        int count = 0;
        for (Employee employee : employeeDB) {
            if (employee.getDepartment() == depart) {
                count++;
            }
        }
        return sumSalaryInDepartment(depart) / count;
    }

    public void indexSalaryInDepartment(int depart, int index) {
        for (Employee employee : employeeDB) {
            if (employee.getDepartment() == depart) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public void printEmployeeInDepartment(int depart) {
        System.out.println("Сотрудники департамента " + depart);
        for (Employee employee : employeeDB) {
            if (employee.getDepartment() == depart) {
                System.out.println("Employee{" +
                        "id= " + employee.getId() +
                        " surname= " + employee.getSurname() +
                        " name= " + employee.getName() +
                        " patronymic= " + employee.getPatronymic() +
                        " salary= " + employee.getSalary() +
                        '}');
            }
        }
    }

    public void addEmployee(){
        for (int i = 0; i < employeeDB.length; i++) {
            if(employeeDB[i] == null){
                employeeDB[i] =new Employee("Новичок", "Новичков", "Петрович", 2, 27700f);
            }
        }
    }

    public void deleteEmployee(String fio){
        Employee[] newEmployeeDB = new Employee[10];
        String[] employeeArray = fio.split(" ");
        for (int i = 0; i < employeeDB.length; i++) {
            if (!Objects.equals(employeeDB[i].getSurname(), employeeArray[0]) && !Objects.equals(employeeDB[i].getName(), employeeArray[1])
                    && !Objects.equals(employeeDB[i].getPatronymic(), employeeArray[2])) {
                newEmployeeDB[i] = employeeDB[i];
            }
        }
        employeeDB = Arrays.copyOf(newEmployeeDB,10);
    }

    public void deleteEmployee(int id){
        Employee[] newEmployeeDB = new Employee[10];
        for (int i = 0; i < employeeDB.length; i++) {
            if (employeeDB[i].getId() != id) {
                newEmployeeDB[i] = employeeDB[i];
            }
        }
        employeeDB = Arrays.copyOf(newEmployeeDB,10);
    }

    public void changeEmployee(String fio, int depart, int salary) {
        String[] employeeArray = fio.split(" ");
        for (Employee employee : employeeDB) {
            if (Objects.equals(employee.getSurname(), employeeArray[0]) && Objects.equals(employee.getName(), employeeArray[1])
                    && Objects.equals(employee.getPatronymic(), employeeArray[2])) {
                employee.setDepartment(depart);
                employee.setSalary(salary);
            }
        }
    }

    public void printEmployeeInDepartment() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Сотрудники отдела " + i);
            for (Employee employee : employeeDB) {
                if (employee.getDepartment() == i) {
                    System.out.println("Employee{" +
                            "id= " + employee.getId() +
                            " surname= " + employee.getSurname() +
                            " name= " + employee.getName() +
                            " patronymic= " + employee.getPatronymic() +
                            " salary= " + employee.getSalary() +
                            '}');
                }
            }
        }
    }

    public void findEmployeeWithSalaryMoreThan(float salary) {
        System.out.println("Сотрудники с зарплатой больше, чем " + salary);
        for (Employee employee : employeeDB) {
            if (employee.getSalary() > salary) {
                System.out.println("Employee{" +
                        "id= " + employee.getId() +
                        " surname= " + employee.getSurname() +
                        " name= " + employee.getName() +
                        " patronymic= " + employee.getPatronymic() +
                        " salary= " + employee.getSalary() +
                        '}');
            }
        }
    }

    public void findEmployeeWithSalaryLessThan(float salary) {
        System.out.println("Сотрудники с зарплатой меньше, чем " + salary);
        for (Employee employee : employeeDB) {
            if (employee.getSalary() < salary) {
                System.out.println("Employee{" +
                        "id= " + employee.getId() +
                        " surname= " + employee.getSurname() +
                        " name= " + employee.getName() +
                        " patronymic= " + employee.getPatronymic() +
                        " salary= " + employee.getSalary() +
                        '}');
            }
        }
    }
}
