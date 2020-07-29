package com.company;

public class EmailApp {

    public static void main(String[] args) {
        Email email1 = new Email("Siddhant", "Singh");
        System.out.println(email1.getPW());

        email1.changePassword("6135012sd5rs");
        System.out.println(email1.getPW());

        email1.setAlternateEmail("ododododoo@doodod.com");
        System.out.println(email1.getAltEmail());

        email1.setCap(700);
        System.out.println(email1.getCap());

        email1.showInfo();

    }
}
