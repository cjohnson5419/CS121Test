import java.util.*;

public class Customer extends Account {
    ArrayList<Account> accountArrayList = new ArrayList<>();
    int customerPin;
    String customerFirst;
    String customerLast;
    int customerNum;
    int numberOfCustomers = 1;

    public Customer(int customerPin, String customerFirst, String customerLast, int balance) {
        super(balance);
        this.customerPin = customerPin;
        this.customerFirst = customerFirst;
        this.customerLast = customerLast;
        this.customerNum = numberOfCustomers;
        numberOfCustomers++;
    }

    public ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }

    public void addAccount(Account account) {
        accountArrayList.add(account);
    }
    public void removeAccount(Account account) {
        accountArrayList.remove(account);
    }
    public Account getAccount(int accountNum) {
        Account foundAccount = null;
        for (Account account : accountArrayList) {
            if (account.getAccountNumber() == accountNum) {
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }

    public int getCustomerPin() {
        return customerPin;
    }

    public String getCustomerFirst() {
        return customerFirst;
    }

    public String getCustomerLast() {
        return customerLast;
    }



    @Override
    public String toString() {
        return
                "First Name: " + customerFirst +
                "\t\nLast Name: " + customerLast +
                "\t\nPIN: " + customerPin;
    }



}
