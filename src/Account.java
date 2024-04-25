public class Account {
    int balance;
    int accountNumber;
    static int numberOfAccount = 1000;
    int i = 0;

    public Account(int initialDepot) {
        this.balance = initialDepot;
        this.accountNumber = numberOfAccount;
        numberOfAccount++;
    }
    void deposit(int userDeposit) {
        balance = userDeposit + balance;
        System.out.printf("New Balance is $%d\n", balance);
    }
    void withdraw(int userWithdraw) {
        if (userWithdraw > balance){
            System.out.println("Insufficient Funds");
        }
        else {
            balance = balance - userWithdraw;
            System.out.printf("You withdrew $%d\nNew Balance is $%d", userWithdraw, balance);
        }
    }

    @Override
    public String toString() {
        return String.format("Account Number: %d\n\tBalance: $%d", accountNumber, balance);
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
