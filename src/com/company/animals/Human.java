package com.company.animals;

import com.company.devices.Car;
import com.company.devices.Phone;


import java.util.*;

public class Human extends Animal {
    public String firstName;
    public String lastName;

    public Phone phone;
    public Double cash;
    public Car[] garage;


    public void getValuesOfCars() {
        int i = 0;
        for (i = 0; i <= this.garage.length; i++) {
            System.out.println(this.garage[i].getValue());

        }
    }
        public void getCarsByYearOfProduction () {
            int i = 0;
            int j = 0;
            for (i = 0; i < this.garage.length; i++) {
                int first = this.garage[i].getYearOfProduction();

                for (j = 1; j < this.garage.length; j++) {

                    if (first <= this.garage[j].getYearOfProduction()) {
                        this.garage[first] = this.garage[j];
                    }

                }
            }
        }

        public Car[] getCars ()
        {
            return this.garage;

        }
        public Car getCar ( int pos){

            return this.garage[pos - 1];
        }

        public void setCar (Car car,int pos){

            this.garage[pos] = car ;
        }


        public String[] fingerNames;

        public final int FINGER_COUNT = 10;
        public final static String HUMAN_SPECIE = "homo sapiens";


        private Double salary;

    public Human(Double salary) {
            super(HUMAN_SPECIE);
            this.setSalary(salary);
            fingerNames = new String[FINGER_COUNT];
            garage = new Car[10];

        }


    public Human( int sizeGarage){
            super(HUMAN_SPECIE);
          garage = new Car[sizeGarage];
        }


        public Double getSalary () {

        return this.salary;
        }

        public void setSalary (Double newSalary){
            if (newSalary > 0) {
                this.salary = newSalary;
            } else {
                System.out.println("NOBODY WILL PAY FOR NOT WORKING");
                this.salary = 0.0;
            }
        }


    }


