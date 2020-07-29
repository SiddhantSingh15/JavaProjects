package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Teacher Lizzie = new Teacher(1234, "Lizzie", 5000);
        Teacher Bob = new Teacher(5678, "Bob", 4800);
        Teacher John = new Teacher(1878, "John", 5000);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(Lizzie);
        teacherList.add(Bob);
        teacherList.add(John);

        Student Siddhant = new Student(2082, "Siddhant", 13);
        Student James = new Student(1234, "James", 12);
        Student Moh = new Student(9872, "Moh", 63);

        List<Student> studentList = new ArrayList<>();
        studentList.add(Siddhant);
        studentList.add(James);
        studentList.add(Moh);

        School BSK = new School(teacherList, studentList);

        Siddhant.getInfo();

        Siddhant.payFees(20000);
        James.payFees(19841);
        Moh.payFees(8457);

        John.setSalary(8000);

        John.receiveSalary();
        Lizzie.receiveSalary();
        Bob.receiveSalary();

        Student Elijah = new Student(7984, "Elijah", 13);
        BSK.addStudent(Elijah);

        BSK.getInfo();

    }




}
