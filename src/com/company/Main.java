package com.company;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeDB = new EmployeeBook();
        employeeDB.getAllEmployee();
        System.out.println("Общие затраты на зарплаты сотрудников составляют: " + employeeDB.sumSalary());
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeDB.employeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeDB.employeeWithMaxSalary().toString());
        System.out.println("Средняя зарплата: " + employeeDB.avgSalary());
        employeeDB.printFio();
        employeeDB.indexSalary(10);
        employeeDB.getAllEmployee();
        System.out.println("Сотрудник с максимальной зарплатой в отделе 3 " + employeeDB.employeeWithMaxSalaryInDepartment(3));
        System.out.println("Сотрудник с максимальной зарплатой в отделе 5 " + employeeDB.employeeWithMinSalaryInDepartment(5));
        System.out.println("Общие затраты на зарплаты сотрудников отдела 4 составляют: " + employeeDB.sumSalaryInDepartment(4));
        System.out.println("Средняя зарплата отдела 2: " + employeeDB.avgSalaryInDepartment(2));
        employeeDB.indexSalaryInDepartment(2,10);
        employeeDB.printEmployeeInDepartment(2);
        employeeDB.findEmployeeWithSalaryLessThan(15000);
        employeeDB.findEmployeeWithSalaryMoreThan(30000);
        employeeDB.deleteEmployee("Никитин Никита Иванович");
        employeeDB.addEmployee();
        employeeDB.deleteEmployee(2);
        employeeDB.addEmployee();
        employeeDB.changeEmployee("Петров Петр Петрович",2,21000);
        employeeDB.printEmployeeInDepartment();
    }
}
