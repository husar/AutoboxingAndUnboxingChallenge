package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bank {
    private ArrayList<Branch> branches;
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public Bank( String name) {
        branches = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBranch(String address){
        if (findBranch(address) == -1){
            branches.add(new Branch(address));
        }else {
            System.out.println("Branch with this name already exists.");
        }
    }

    private int findBranch(String address){
        for (int i = 0; i < branches.size(); i++){
            if (address.equals(branches.get(i).getAddress())){
                return i;
            }
        }
        return -1;
    }

    public void addNewCustomerWithFirstTransaction(String addressOfBranch, String nameOfCustomer, double firstTransaction){
        int positionOfBranch = findBranch(addressOfBranch);
        if (positionOfBranch == -1){
            System.out.println("We don't have this branch");
        }else {
            branches.get(positionOfBranch).addNewCustomer(nameOfCustomer, firstTransaction);
            System.out.println("New customer: " + nameOfCustomer + " was added with first transaction " + String.format("%.2f", firstTransaction) + "€");
        }
    }

    public void addNextTransactionToCustomer(String branch, String nameOfCustomer, double transaction){
        int positionOfBranch = findBranch(branch);
        if (positionOfBranch == -1){
            System.out.println("We don't have access to this branch.");
        }else {
            branches.get(positionOfBranch).addAnotherTransaction(nameOfCustomer,transaction);
        }
    }

    public void showCustomerForBranch(String branch, String nameOfCustomer){
        int positionOfBranch = findBranch(branch);
        if (positionOfBranch == -1){
            System.out.println("We don't have this branch");
        }else {
            if (branches.get(positionOfBranch).getCustomers().size() == 0){
                System.out.println("There are not customers.");
            }else {
                System.out.println("Do you want also transactions of customer? (yes/no)");
                String alsoTransactions = scanner.nextLine();
                for (int i = 0; i < branches.get(positionOfBranch).getCustomers().size(); i++) {
                    System.out.print((i + 1) + ". " + branches.get(positionOfBranch).getCustomers().get(i).getName());
                    if (alsoTransactions.equals("yes")){
                        System.out.print(": [");
                        for (int j = 0; j<branches.get(positionOfBranch).getCustomers().get(i).getTransactions().size();j++){
                            System.out.print(String.format("%.2f",branches.get(positionOfBranch).getCustomers().get(i).getTransactions().get(j))+"€");
                            if (j != (branches.get(positionOfBranch).getCustomers().get(i).getTransactions().size()-1)){
                                System.out.print("; ");
                            }
                        }
                        System.out.print("]");
                    }
                    System.out.println();
                }
            }
        }
    }

    public void printBranches(){
        if (branches.size() == 0){
            System.out.println("There are no branches");
        }else {
            for (int i = 0; i<branches.size(); i++){
                System.out.println((i+1)+". "+branches.get(i).getAddress());
            }
        }
    }
}
