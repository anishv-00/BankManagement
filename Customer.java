import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<BankAccount> bankAccounts;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        bankAccounts = new ArrayList<>();
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void createBankAccount(String accountType, double initialDeposit) {
        int accountNumber = generateAccountNumber();
        BankAccount bankAccount;

        if (accountType.equalsIgnoreCase("savings")) {
            bankAccount = new SavingsAccount(accountNumber, initialDeposit);
        } 
        
        else if (accountType.equalsIgnoreCase("checking")) {
            bankAccount = new CheckingAccount(accountNumber, initialDeposit);
        } 
        
        else {
            System.out.println("Invalid account type. Account not created.");
            return;
        }

        bankAccounts.add(bankAccount);
        System.out.println("Bank account created successfully. Account Number: " + accountNumber);
    }

    public BankAccount getBankAccountByNumber(int accountNumber) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                return bankAccount;
            }
        }
        return null;
    }

    private int generateAccountNumber() {
        return bankAccounts.size() + 1;
    }
}
