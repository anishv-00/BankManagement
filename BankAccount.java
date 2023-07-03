import java.util.ArrayList;
import java.util.List;


public class BankAccount {
    private int accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        String transaction = "Deposit: +" + amount + ", New Balance: $" + balance;
        transactionHistory.add(transaction);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            String transaction = "Withdrawal: -" + amount + ", New Balance: $" + balance;
            transactionHistory.add(transaction);
        } 
        
        else {
            System.out.println("Insufficient balance.");
        }
    }
}
