package com.company;

import java.util.Scanner;

public class Email {

    private final String firstName;
    private final String lastName;
    private String password;
    private final String department;
    private int mailboxCap = 500;
    private final String fullEmail;
    private String alternateEmail;

    public Email(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
        this.department = setDept();
        int defaultLength = 10;
        this.password = setPassword(defaultLength);
        this.fullEmail = makeEmail(this.firstName, this.lastName, this.department);
        System.out.println(fullEmail);

    }

    private String setDept(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the department \n");
        System.out.print("1 for SALES \n");
        System.out.print("2 for DEVELOPMENT \n");
        System.out.print("3 for ACCOUNTING \n");
        System.out.print("0 for NONE \n");
        System.out.print("Choice: ");
        int deptChoice = in.nextInt();
        if  (deptChoice == 1){
            return "sales";
        } else if (deptChoice == 2){
            return "development";
        } else if (deptChoice == 3){
            return "accounting";
        } else {
            return "";
        }
    }

    private String setPassword(int length){
        String pwSet = "ABCDEFGHIJKLMNOPLQRSTUVWXYZ123456789!@#$^&*()";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int) (Math.random() * pwSet.length());
            password[i] = pwSet.charAt(rand);
        }
        return new String(password).toLowerCase();
    }

    private String makeEmail(String fName, String lName, String dept){
        return fName.toLowerCase() + lName.toLowerCase() + "@" + dept + ".company.com";
    }

    public void setCap(int capacity){
        this.mailboxCap = capacity;
    }

    public int getCap(){
        return mailboxCap;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    public String getAltEmail(){
        return alternateEmail;
    }

    public void changePassword(String newPW){
        this.password = newPW;
    }

    public String getPW(){
        return password;
    }

    public void showInfo(){
        System.out.println("=====================================");
        System.out.println("NAME: " + firstName + " " + lastName);
        System.out.println("DEPARTMENT: " + department);
        System.out.println("EMAIL: " + fullEmail);
        System.out.println("PASSWORD: " + password);
        System.out.println("MAIL CAPACITY: " + mailboxCap);
        System.out.println("ALTERNATE EMAIL: " + alternateEmail);
        System.out.println("=====================================");
    }

}
