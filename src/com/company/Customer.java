package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double firstTransaction) {
        this.name = name;
        transactions = new ArrayList<>();
        insertFirstTransaction(firstTransaction);
    }

    private void insertFirstTransaction(double transaction){
            if (transaction > 0) {
                transactions.add(transaction);
            }else {
                transactions.add(200.0);
            }
    }

    public void addTransaction(double transaction){
        transactions.add(transaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
