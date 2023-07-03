import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends BankAccount {
    private static final double WITHDRAWAL_LIMIT = 10000;

    public SavingsAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    public void withdraw(double amount) {
        if (amount <= getBalance() && amount <= WITHDRAWAL_LIMIT) {
            super.withdraw(amount);
        } 
        
        else if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal amount exceeds the limit.");
        } 
        
        else {
            System.out.println("Insufficient balance.");
        }
    }
}
