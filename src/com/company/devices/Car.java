package com.company.devices;

import com.company.Transaction;
import com.company.animals.Human;



import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Car extends Device {

    public Double engineSize;
    public String fuelType;
    final static Double MAX_FUEL = 1.0;
    public Double currentFuel = 0.0;

    public List<Transaction> transactions = new ArrayList<>();
    public List<Human> owners = new ArrayList<>();

    @Override
    public void turnOn() {
        System.out.println("Car is turned on");
    }
    public int soldTime() {
        return owners.size() - 1;}



    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        Car[] forSale = seller.getCars();

        Car sold1 = null;
        for (Car car : forSale) {
            if (car == this) {
                sold1 = car;
                break;
            }
        }

        if (sold1 == null) {
            throw new Exception("The seller does not have the car in the garage");
        }



        Car[] inGarage = buyer.garage;
        boolean hasEmptySpot = false;
        for (Car car : inGarage) {
            if (car == null) {
                hasEmptySpot = true;
                break;

            }
        }

        if (!hasEmptySpot ) {
            throw new Exception("Buyer does not have any available parking spots in the garage");
        }


        if (buyer.cash < price) {
            throw new Exception("Buyer does not have enough cash");
        }

        Car[] garage = seller.garage;
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == sold1) {
                garage[i] = null;
                break;
            }
        }


        for (int i = 0; i < inGarage.length; i++) {
            if (inGarage[i] == null) {
                inGarage[i] = sold1;
                break;
            }
        }


        seller.cash += price;
        buyer.cash -= price;


        System.out.println("Car has been sold");


        sold1.owners.add(buyer);


        Transaction transaction = new Transaction();
        transaction.buyer = buyer;
        transaction.date = new Date();
        transaction.price = price;
        transaction.seller = seller;
        transactions.add(transaction);

    }
    public boolean everSold(Human A, Human B) {
        int i;
        for (i = 0; i < owners.size(); i++) {
            if (owners.get(i) == A) {
                break;
            }
        }


        for (; i < owners.size(); i++) {
            if (owners.get(i) == B) {
                return true;
            }
        }

        return false;
    }
        public void refuel () {
            currentFuel = MAX_FUEL;
        }
    }

