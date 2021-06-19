package com.company;

import com.company.animals.*;
import com.company.devices.*;



public class Main {

    public static void main(String[] args) {


        Human me = new Human(1000.0);
        me.firstName = "Jan";
        me.lastName = "Kowalski";

        me.cash = 0.0;

        Car fiat = new Car();
        fiat.engineSize = 1.9;
        fiat.fuelType = "Diesel";
        fiat.setProducer("Fiat");
        fiat.setModel("Bravo");
        fiat.setValue(16000.0);
        fiat.setYearOfProduction(2009);
        me.setCar(fiat, 0);
        ;
        fiat.owners.add(me);

        Car audi = new Car();
        audi.engineSize = 3.5;
        audi.fuelType = "Diesel";
        audi.setProducer("Audi");
        audi.setModel("A6");
        audi.setValue(42000.0);
        audi.setYearOfProduction(2012);
        me.setCar(audi, 1);
        ;
        audi.owners.add(me);

        Car tesla = new Car();
        tesla.engineSize = 2.0;
        tesla.fuelType = "Electric";
        tesla.setProducer("Tesla");
        tesla.setModel("Model S");
        tesla.setValue(120000.0);
        tesla.setYearOfProduction(2019);
        me.setCar(tesla, 2);

        tesla.owners.add(me);

        for (Car car : me.getCars()) {
            if(car != null) {
                System.out.println(car.getProducer() + " " + car.getYearOfProduction());
            }
        }


        Human george = new Human(90000.0);
        george.cash = 50000.0;
        try {
            fiat.sell(me, george, 49000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            audi.sell(me, george, 60000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Human humanA = new Human(60000.0);
        humanA.cash = 0.0;
        humanA.firstName = "George";
        Human humanB = new Human(50000.0);
        humanB.cash = 1000000.0;
        humanB.firstName = "Frank";
        Human humanC = new Human(70000.0);
        humanC.cash = 4000000.0;
        humanC.firstName = "Robert";
        Human humanD = new Human(23000.0);
        humanD.cash = 7600000.0;
        humanD.firstName = "Steve";


        Car honda = new Car();
        honda.setYearOfProduction(2007);
        honda.setProducer("Honda");
        humanA.setCar(honda, 0);
        honda.owners.add(humanA);
        try {
            honda.sell(humanA, humanB, 54000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        try {
            honda.sell(humanB, humanC, 46000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            honda.sell(humanA, humanD, 41000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Car has been sold " + honda.soldTime() +" times ");




        if (honda.everSold(humanC, humanB)) {
            System.out.println("HumanC sold the car to humanB");
        } else {
            System.out.println("HumanC did not sell the car to humanB");
        }


        for (Transaction transaction : honda.transactions) {
            System.out.println("Seller: " + transaction.seller.firstName
                    + ", Buyer: " + transaction.buyer.firstName
                    + ", " + transaction.price
                    + ", Date: " + transaction.date.toString());

        }

    }
}