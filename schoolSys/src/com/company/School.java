package com.company;

import java.util.List;

public class School {

    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalFund;
    private static int totalSpend;

    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalFund = 0;
        totalSpend = 0;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public int getTotalFund() {
        return totalFund;
    }

    public static void addMoney(int income) {
        totalFund += income;
    }

    public int getTotalSpend() {
        return totalSpend;
    }

    public static void giveSalary(int salary){
        totalSpend += salary;
        totalFund -= salary;
    }

    public void getInfo(){
        System.out.println("--------------------------------------");
        System.out.println("*Teachers: ");
        for (Teacher teacher : this.teachers){
            System.out.println("- " + teacher.getName());
            System.out.println("  = ID: " + teacher.getID());
            System.out.println("  = Salary: " + teacher.getSalary());
        }
        System.out.println("*Students: ");
        for(Student student : this.students){
            System.out.println("- " + student.getName());
            System.out.println("  = ID: " + student.getId());
            System.out.println("  = Year group: " + student.getYearGroup());
            System.out.println("  = Fees pending: " + student.getFees());
        }
        System.out.println("*Fund: " + this.getTotalFund());
        System.out.println("*Spending: " + this.getTotalSpend());
        System.out.println("--------------------------------------");
    }
}
