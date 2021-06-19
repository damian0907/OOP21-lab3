package com.company;

import com.company.animals.Human;

import java.util.Date;

public class Transaction {
    public Human seller;
    public Human buyer;
    public Double price;
    public Date date;

    public Transaction() {

    }


    public void printTransaction() {
        System.out.println(seller.name + " sold to " + buyer.name + " at " + date + " for " + price);
    }
}
