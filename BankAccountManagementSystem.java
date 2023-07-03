import java.util.ArrayList;
import java.util.List;

public class BankAccountManagementSystem {
    private List<Customer> customers;

    public BankAccountManagementSystem() {
        customers = new ArrayList<>();
    }

    public void createCustomer(String name) {
        int id = generateCustomerID();
        Customer customer = new Customer(id, name);
        customers.add(customer);
        System.out.println("Customer created successfully. Customer ID: " + id);
    }

    public Customer getCustomerByID(int id) {
        for (Customer customer : customers) {
            if (customer.getID() == id) {
                return customer;
            }
        }
        return null;
    }

    public void deposit(Customer customer, int accountNumber, double amount) {
        BankAccount bankAccount = customer.getBankAccountByNumber(accountNumber);
        if (bankAccount != null) {
            bankAccount.deposit(amount);
            System.out.println("Deposit successful. Current balance: $" + bankAccount.getBalance());
        } 
        
        else {
            System.out.println("Bank account not found.");
        }
    }

    public void withdraw(Customer customer, int accountNumber, double amount) {
        BankAccount bankAccount = customer.getBankAccountByNumber(accountNumber);
        if (bankAccount != null) {
            bankAccount.withdraw(amount);
        } 
        
        else {
            System.out.println("Bank account not found.");
        }
    }

    public void transferFunds(Customer customer, int sourceAccountNumber, int destinationAccountNumber, double amount) {
        BankAccount sourceAccount = customer.getBankAccountByNumber(sourceAccountNumber);
        BankAccount destinationAccount = getBankAccountByNumber(destinationAccountNumber);

        if (sourceAccount != null && destinationAccount != null) {
            if (sourceAccount.getBalance() >= amount) {
                sourceAccount.withdraw(amount);
                destinationAccount.deposit(amount);
                System.out.println("Funds transferred successfully.");
                System.out.println("Source Account Balance: $" + sourceAccount.getBalance());
                System.out.println("Destination Account Balance: $" + destinationAccount.getBalance());
            } 
            
            else {
                System.out.println("Insufficient balance in the source account.");
            }
        } 
        
        else {
            System.out.println("One or both accounts not found.");
        }
    }

    private BankAccount getBankAccountByNumber(int accountNumber) {
        for (Customer customer : customers) {
            BankAccount bankAccount = customer.getBankAccountByNumber(accountNumber);
            if (bankAccount != null) {
                return bankAccount;
            }
        }
        return null;
    }

    private int generateCustomerID() {
        return customers.size() + 1;
    }
}
