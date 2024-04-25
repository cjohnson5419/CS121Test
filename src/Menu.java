import com.sun.beans.editors.ColorEditor;

import java.sql.SQLOutput;
import java.util.*;

public class Menu {
    Scanner scan = new Scanner(System.in);
    Bank bank = new Bank();
    public void getMenu() {
        while (true) {
            System.out.print("******MENU******\n1) Access Account\n2) Open New Account\n3) Close All Accounts\n4) Sort Customer List\n 5) Exit\n>>");
            int userInput = scan.nextInt();
            if (userInput == 1) {
                accessAccount();
            }
            else if (userInput == 2) {
                openAccount();
            }


            else if (userInput == 3) {
                    deleteAccounts();
            }
            else if (userInput == 4) {
                System.out.println("Sorting Customers...");
                sortArray();
            }
            else if (userInput == 5) {
                System.out.println("Exiting...");
                break;
            }
            else {
                System.out.println("Invalid Number!");
            }
        }

    }
    public void accessAccount() {
        Customer customer;

        System.out.print("Please Enter PIN number: ");
        int accountPin = scan.nextInt();
        customer = bank.getCustomer(accountPin);

        if (customer == null) {
            System.out.println("PIN Not Valid");
        }
        else {
            System.out.println(customer.toString());
            System.out.print("Choose An Account To View: ");
            int accountNumber = scan.nextInt();

            Account accountNum = customer.getAccount(accountNumber);
            while (true) {
                if (accountNum == null) {
                    System.out.println("Account Not Found");
                    break;
                }
                else {
                    System.out.println("\t" + accountNum.toString());
                    System.out.print("\t-----Please Make a Selection-----\n\t1) Deposit\n\t2) Withdraw\n\t3) Account Balance\n\t4) Close Account\n\t5) Exit\n\t>>");
                    int userInput = scan.nextInt();

                    if (userInput == 1) {
                        System.out.print("\tEnter Deposit Amount: ");
                        int userDeposit = scan.nextInt();
                        accountNum.deposit(userDeposit);


                    }
                    else if (userInput == 2) {
                        System.out.print("\tEnter Withdraw Amount: ");
                        int userDeposit = scan.nextInt();
                        accountNum.withdraw(userDeposit);

                    }
                    else if (userInput == 3) {
                        System.out.println("\t" +accountNum.getBalance());
                    }
                    else if (userInput == 4) {
                        System.out.println("\tRemoving Account...");
                        customer.removeAccount(accountNum);
                        break;
                    }
                    else if (userInput == 5) {
                        break;
                    }
                    else {
                        System.out.println("\tInvalid Number...");
                    }

                }
            }
        }


    }
    public void openAccount() {
        System.out.print("\tAre You A New Customer?\n\t1) Yes\n\t2) No\n\t>>");
        int userInput = scan.nextInt();

        while (true) {
            if (userInput == 1) {
                createNewCustomer();
                break;
            }
            else if (userInput == 2) {
                Customer customer;

                System.out.print("\tEnter PIN Number: ");
                int userPin = scan.nextInt();
                customer = bank.getCustomer(userPin);

                if (customer == null) {
                    break;
                }
                else {
                    System.out.print("Enter Amount To Deposit: ");
                    userInput = scan.nextInt();

                    Account newAccount = new Account(userInput);
                    customer.addAccount(newAccount);
                    System.out.println("New Account Created: " + newAccount.getAccountNumber());
                    break;

                }
            }
        }
    }
    public void createNewCustomer() {
        System.out.print("\tEnter First Name: ");
        String userFirst = scan.next();
        System.out.print("\tEnter Last Name: ");
        String userLast = scan.next();
        System.out.print("\tEnter PIN Number: ");
        int userPin = scan.nextInt();
        System.out.print("\tEnter A Balance: ");
        int userBalance = scan.nextInt();


        Customer newCustomer = new Customer(userPin, userFirst, userLast, userBalance);
        bank.addCustomer(newCustomer);

        System.out.print("\tEnter an Amount to Deposit: ");
        int userDeposit = scan.nextInt();
        Account newAccount = new Account(userDeposit);
        newCustomer.addAccount(newAccount);
        System.out.println("New Account Created:\nAccount Number: " + newAccount.getAccountNumber());


    }
    public void deleteAccounts() {
        Customer customer;
        System.out.print("Are You Sure? Enter Your PIN to Confirmation\n>>");
        int userInput = scan.nextInt();
        customer = bank.getCustomer(userInput);
        if (customer == null) {
            System.out.println("Incorrect PIN: Account Deletion Stopped.");
        }
        else {
            System.out.println("Deleting Accounts...");
            customer.accountArrayList.removeAll(customer.getAccountArrayList());
        }

    }
    public void sortArray() {
        bank.sort();
    }
}
