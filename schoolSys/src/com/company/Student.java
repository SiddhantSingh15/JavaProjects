package com.company;

public class Student {

    private int id;
    private String name;
    private int fees;
    private int yearGroup;
    private int feesPaid;

    public Student(int id, String name, int yearGroup){
        this.feesPaid = 0;
        this.fees = 30000;
        this.id = id;
        this.name = name;
        this.yearGroup = yearGroup;
    }


    public void setYearGroup(int yearGroup1){
        this.yearGroup = yearGroup1;
    }

    public void updateFeesPaid(int fees1){
        this.feesPaid += fees1;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFees() {
        return fees;
    }

    public int getYearGroup() {
        return yearGroup;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public void payFees(int fees){
        this.updateFeesPaid(fees);
        School.addMoney(fees);
        this.fees -= fees;
    }

    public void getInfo(){
        System.out.println("--------------------------------------");
        System.out.println("Name: " + this.getName());
        System.out.println("ID: " + this.getId());
        System.out.println("Year group: " + this.getYearGroup());
        System.out.println("Fees pending: " + this.getFees());
        System.out.println("Total fees paid: " + this.getFeesPaid());
        System.out.println("--------------------------------------");
    }
}

