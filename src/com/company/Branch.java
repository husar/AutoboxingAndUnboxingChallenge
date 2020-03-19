package com.company;

import java.util.ArrayList;

public class Branch {
    private String address;
    private ArrayList<Customer> customers;

    public Branch(String address) {
        this.address = address;
        customers = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addNewCustomer(String name, double firstTransaction){
        if (findCustomer(name) == -1) {
            customers.add(new Customer(name, firstTransaction));
            System.out.println("New customer: " + name + " was added with first transaction " + String.format("%.2f", firstTransaction) + "€");
        }
        else {
            System.out.println("Customer with this name already exist!");
        }
    }

    public void addAnotherTransaction(String name, double transaction){
        int position = findCustomer(name);
        if (position != -1){
            if (transaction > 0){
                customers.get(position).addTransaction(transaction);
                System.out.println("Transaction was accepted");
            }else {
                double balance = 0;
                for (int i = 0; i < customers.get(position).getTransactions().size(); i++) {
                    balance += customers.get(position).getTransactions().get(i);
                }
                if ((balance+transaction) > 0){
                    customers.get(position).addTransaction(transaction);
                    System.out.println("Transaction was accepted");
                }
                else {
                    System.out.println("You don't have enough money for this transaction.");
                }
            }
        }else {
            System.out.println("You are not registered in this transaction");
        }
    }

    private int findCustomer(String name){
        for (int i = 0; i < customers.size(); i++){
            if(customers.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
