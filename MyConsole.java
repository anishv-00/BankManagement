import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyConsole {
    public static void main(String[] args) {
        BankAccountManagementSystem bankSystem = new BankAccountManagementSystem();
        Scanner scanner = new Scanner(System.in);

        int choice = -3;
        while (choice != 0) {
            System.out.println("Bank Account Management System");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Bank Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. View Transaction History");
            System.out.println("7. Transfer Funds");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();
                bankSystem.createCustomer(name);
            } 
            
            else if (choice == 2) {
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                scanner.nextLine();
                Customer customer = bankSystem.getCustomerByID(customerID);
                if (customer != null) {
                    System.out.print("Enter account type (savings/checking): ");
                    String accountType = scanner.nextLine();
                    System.out.print("Enter initial deposit amount: ");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine();
                    customer.createBankAccount(accountType, initialDeposit);
                } 
                
                else {
                    System.out.println("Customer not found.");
                }
            } 
            
            else if (choice == 3) {
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                scanner.nextLine();
                Customer customer = bankSystem.getCustomerByID(customerID);
                if (customer != null) {
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    bankSystem.deposit(customer, accountNumber, depositAmount);
                } 
                
                else {
                    System.out.println("Customer not found.");
                }
            } 
            
            else if (choice == 4) {
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                scanner.nextLine();
                Customer customer = bankSystem.getCustomerByID(customerID);

                if (customer != null) {
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();
                    BankAccount bankAccount = customer.getBankAccountByNumber(accountNumber);

                    if (bankAccount != null) {
                        if (bankAccount.getBalance() >= withdrawalAmount) {
                            bankSystem.withdraw(customer, accountNumber, withdrawalAmount);
                            System.out.println("Withdrawal successful. Current balance: $" + bankAccount.getBalance());
                        } 
                        
                        else {
                            System.out.println("Insufficient balance.");
                        }
                    } 
                    
                    else {
                        System.out.println("Bank account not found.");
                    }

                } 
                
                else {
                    System.out.println("Customer not found.");
                }
            } 
            
            else if (choice == 5) {
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                scanner.nextLine(); 
                Customer customer = bankSystem.getCustomerByID(customerID);

                if (customer != null) {
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    BankAccount bankAccount = customer.getBankAccountByNumber(accountNumber);

                    if (bankAccount != null) {
                        System.out.println("Account balance: $" + bankAccount.getBalance());
                    } 
                    
                    else {
                        System.out.println("Bank account not found.");
                    }
                } 
                
                else {
                    System.out.println("Customer not found.");
                }
            } else if (choice == 6) {
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                scanner.nextLine(); 
                Customer customer = bankSystem.getCustomerByID(customerID);

                if (customer != null) {
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    BankAccount bankAccount = customer.getBankAccountByNumber(accountNumber);

                    if (bankAccount != null) {
                        List<String> transactionHistory = bankAccount.getTransactionHistory();
                        if (transactionHistory.isEmpty()) {
                            System.out.println("No transactions found for this account.");
                        } 
                        
                        else {
                            System.out.println("Transaction history:");
                            for (String transaction : transactionHistory) {
                                System.out.println(transaction);
                            }
                        }
                    } 
                    
                    else {
                        System.out.println("Bank account not found.");
                    }
                } 
                
                else {
                    System.out.println("Customer not found.");
                }
            } 
            
            else if (choice == 7) {
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                scanner.nextLine();
                Customer customer = bankSystem.getCustomerByID(customerID);

                if (customer != null) {
                    System.out.print("Enter source account number: ");
                    int sourceAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter destination account number: ");
                    int destinationAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();

                    bankSystem.transferFunds(customer, sourceAccountNumber, destinationAccountNumber, transferAmount);
                } 
                
                else {
                    System.out.println("Customer not found.");
                }
            }
        }
    }
}
