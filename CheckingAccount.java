import java.util.ArrayList;
import java.util.List;

public class CheckingAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = -1000;

    public CheckingAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    public void withdraw(double amount) {
        double availableBalance = getBalance() + OVERDRAFT_LIMIT;

        if (amount <= availableBalance) {
            super.withdraw(amount);
        } 
        
        else {
            System.out.println("Withdrawal amount exceeds the overdraft limit.");
        }
    }
}
