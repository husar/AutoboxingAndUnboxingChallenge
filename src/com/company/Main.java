package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Bank> banks = new ArrayList<>();

    public static void main(String[] args) {
        Bank VUB = new Bank("VUB");
        VUB.addBranch("Stara Lubovna");
        VUB.addBranch("Poprad");
        VUB.addBranch("Sabinov");
        Bank tatraBanka = new Bank("Tatra Banka");
        tatraBanka.addBranch("Kosice");
        tatraBanka.addBranch("Poprad");
        Bank raiffeisen = new Bank("Raiffeisen bank");
        raiffeisen.addBranch("Poprad");
        banks.add(VUB);
        banks.add(tatraBanka);
        banks.add(raiffeisen);
        System.out.println("Hello welcome in this bank application!!\nChoose bank ");
        int positionOfBank=chooseBank();
        printOptions();
        boolean exit = false;
        while (!exit){
            if (scanner.hasNextInt()){
                int option = scanner.nextInt();
                switch (option){
                    case 0:
                        printOptions();
                        break;
                    case 1:
                        addNewCustomer(positionOfBank);
                        break;
                    case 5:
                        banks.get(positionOfBank).showCustomerForBranch("Poprad");
                        break;
                    default:
                        exit =true;
                        break;
                }
            }else {
                System.out.println("Please choose number from options.");
                printOptions();
            }
            scanner.nextLine();
        }
        //TODO Bug: after adding of new customer to branch is waiting for next 2 numbers then program continue
        //TODO automate adding of new customer with initial transaction to existing branch
        //TODO adding new transactions for customer
        //TODO show list of branches
        //TODO show list of customers -> optionaly with transactions
        //TODO showing list of transactions for 1 defined customer
    }

    public static void addNewCustomer(int positionOfBank){
        System.out.println("Enter the name of customer:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter your first transaction:");
        double firstTransaction = 0;
        boolean isDouble = false;
        while (!isDouble) {
            if (scanner.hasNextDouble()) {
                firstTransaction = scanner.nextDouble();
                scanner.nextLine();
                if (firstTransaction > 0) {
                    String addressOfBank = chooseBranch(positionOfBank);
                    banks.get(positionOfBank).addNewCustomerWithFirstTransaction(addressOfBank,name,firstTransaction);
                    isDouble = true;
                }else {
                    System.out.println("You cannot enter a negative number");
                }
            }
            else {
                System.out.println("Please put a valid number for your first transaction");
            }
            scanner.nextLine();
        }
    }

    public static String chooseBranch(int positionOfBank){
        System.out.println("Please choose your branch:");
        banks.get(positionOfBank).printBranches();
        String addressOfBranch = scanner.nextLine();
        return addressOfBranch;
    }

    public static int chooseBank(){
        boolean exit = false;
        while (!exit){
            for (int i = 0; i<banks.size();i++){
                System.out.println((i+1)+". "+banks.get(i).getName());
            }
            if (scanner.hasNextInt()){
                int positionOfBank = scanner.nextInt() - 1;
                if (positionOfBank>-1 && positionOfBank<banks.size()){
                    return positionOfBank;
                }
                else {
                    System.out.println("Please choose number of bank!");
                }
            }else {
                System.out.println("Please choose number of bank!");
            }
            scanner.nextLine();
        }
        return -1;
    }

    public static void printOptions(){
        System.out.println("Press: \n" +
                "1 - to show the banks you can work with\n" +
                "2 - to add new customer to existing branch with initial transaction\n" +
                "3 - to add new transaction to existing customer\n" +
                "4 - to show list of branches for choosen bank\n" +
                "5 - to show list of customers for choosen bank and branch\n" +
                "6 - to show list of transactions for existing customer\n" +
                "0 - to print options\n" +
                "other number - to exit\n");
    }
}
