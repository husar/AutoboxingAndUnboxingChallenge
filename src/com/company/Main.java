package com.company;

public class Main {

    public static void main(String[] args) {
        Bank VUB = new Bank("VUB");
        VUB.addBranch("Stara Lubovna");
        VUB.addBranch("Poprad");
        VUB.addBranch("Sabinov");
        VUB.addBranch("Sabinov");
        VUB.addNewCustomerWithFirstTransaction("Poprad","Jano",254.52);
        VUB.addNewCustomerWithFirstTransaction("Poprad","Jozef",254);
        VUB.addNewCustomerWithFirstTransaction("Poprad","Adam",1458.50);
        VUB.addNewCustomerWithFirstTransaction("Poprad","Jano",451.02);
        VUB.addNewCustomerWithFirstTransaction("Sabinov","Jano",586.95);
        VUB.addNewCustomerWithFirstTransaction("Sabinov","Erik",254.51);
        VUB.addNextTransactionToCustomer("Poprad","Jano", 158);
        VUB.addNextTransactionToCustomer("Poprad","Jano", -150);
        VUB.addNextTransactionToCustomer("Poprad","Jozef", 300);
        VUB.addNextTransactionToCustomer("Poprad","Jozef", -1500);
        VUB.showCustomerForBranch("Poprad","Jano");
        //TODO options
        //TODO automate adding of new customer with initial transaction to existing branch
        //TODO adding new transactions for customer
        //TODO show list of branches
        //TODO show list of customers -> optionaly with transactions
        //TODO showing list of transactions for 1 defined customer
    }
}
