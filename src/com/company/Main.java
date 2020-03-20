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
                scanner.nextLine();
                switch (option){
                    case 0:
                        printOptions();
                        break;
                    case 1:
                        positionOfBank = chooseBank();
                        printOptions();
                        break;
                    case 2:
                        addNewCustomer(positionOfBank);
                        break;
                    case 3:
                        addNextTransaction(positionOfBank);
                        break;
                    case 4:
                        banks.get(positionOfBank).printBranches();
                        break;
                    case 5:
                        String nameOfBranch = chooseBranch(positionOfBank);
                        banks.get(positionOfBank).showCustomerForBranch(nameOfBranch);
                        break;
                    case 6:
                        showCustomersTransactions(positionOfBank);
                        break;
                    default:
                        exit =true;
                        break;
                }
            }else {
                System.out.println("Please choose number from options.");
                printOptions();
                scanner.nextLine();
            }
        }
        //TODO optimize code for printing transactions in class Bank
    }

    public static void showCustomersTransactions(int positionOfBank){
        String addressOfBranch = chooseBranch(positionOfBank);
        System.out.println("Please enter the name of customer: ");
        String nameOfCustomer = scanner.nextLine();
        banks.get(positionOfBank).showCustomersTransaction(addressOfBranch,nameOfCustomer);
    }

    public static void addNextTransaction(int positionOfBank){
        String addressOfBranch = chooseBranch(positionOfBank);
        System.out.println("Please enter the name of customer: ");
        String nameOfCustomer = scanner.nextLine();
        double transaction = enterValidTransaction();
        banks.get(positionOfBank).addNextTransactionToCustomer(addressOfBranch,nameOfCustomer,transaction);
    }

    public static void addNewCustomer(int positionOfBank){
        System.out.println("Enter the name of customer:");
        String name = scanner.nextLine();
        double firstTransaction = -1;
        while (firstTransaction < 0) {
            firstTransaction = enterValidTransaction();
        }
        String addressOfBank = chooseBranch(positionOfBank);
        banks.get(positionOfBank).addNewCustomerWithFirstTransaction(addressOfBank,name,firstTransaction);
    }


    private static double enterValidTransaction(){
        System.out.println("Enter your transaction:");
        double transaction = 0;
        boolean isDouble = false;
        while (!isDouble) {
            if (scanner.hasNextDouble()) {
                transaction = scanner.nextDouble();
                scanner.nextLine();
                isDouble = true;
            }
            else {
                System.out.println("Please put a valid number for your first transaction");
                scanner.nextLine();
            }
        }
        return transaction;
    }

    private static String chooseBranch(int positionOfBank){
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
                    scanner.nextLine();
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
                "1 - to choose another bank\n" +
                "2 - to add new customer to existing branch with initial transaction\n" +
                "3 - to add new transaction to existing customer\n" +
                "4 - to show list of branches for choosen bank\n" +
                "5 - to show list of customers for choosen bank and branch\n" +
                "6 - to show list of transactions for existing customer\n" +
                "0 - to print options\n" +
                "other number - to exit\n");
    }
}
