package com.company;

import java.util.Scanner;

public class BankAccount {

    int balance;
    int previousTransaction;
    String name;
    String ID;

    BankAccount(String cname, String cID){
        name = cname;
        ID = cID;
    }

    void deposit(int amount){
        if (amount != 0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if (amount < balance){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else{
            System.out.println("No previous transaction");
        }
    }

    void showMenu(){

        char choice = '\0';

        Scanner user_input = new Scanner(System.in);

        System.out.println("Welcome " + name);
        System.out.println("ID: " + ID);
        System.out.println("\n");
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");


        do{
            System.out.println("---------------------------------------");
            System.out.println("Your choice: ");
            choice = user_input.next().charAt(0);
            System.out.println("\n");


            switch (choice){
                case 'A':
                    System.out.println("---------------------------------------");
                    System.out.println("Your balance is: " + balance);
                    break;
                case 'B':
                    System.out.println("---------------------------------------");
                    int amount;
                    System.out.println("Input amount: ");
                    amount = user_input.nextInt();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("---------------------------------------");
                    int withdraw;
                    System.out.println("Withdrawal amount: ");
                    withdraw = user_input.nextInt();
                    withdraw(withdraw);
                    break;
                case 'D':
                    System.out.println("---------------------------------------");
                    getPreviousTransaction();
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Invalid option, please try again: ");
                    choice = user_input.next().charAt(0);
                    break;
            }
        } while (choice != 'E');
        System.out.println("Thank you!");
    }
}
