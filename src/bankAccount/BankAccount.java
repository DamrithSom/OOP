package bankAccount;
import java.util.Scanner;
public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit of $" + amount + " successful. Your balance: $" + this.balance);
        } else {
            System.out.println("Invalid,Please deposit a positive amount.");
        }
    }

    public void withdrawFunds(double amount) {
        if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
                System.out.println("Withdrawal of $" + amount + " successful. Your balance: $" + this.balance);
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please withdraw a positive amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + this.getAccountNumber());
        System.out.println("Customer Name: " + this.getCustomerName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Phone Number: " + this.getPhoneNumber());
        System.out.println("Balance: $" + this.getBalance());
    }

    public void performTransactions() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean e = false;
        while(!e) {
            System.out.println("\n==========M E N U ==========:");
            System.out.println("1. Deposit ");
            System.out.println("2. Withdraw ");
            System.out.println("3. Display Account Details");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    depositFunds(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    withdrawFunds(withdrawAmount);
                    break;

                case 3:
                    displayAccountDetails();
                    break;

                case 0:
                    System.out.println("Program Exit!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        }

        scanner.close();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("123456789", 1000.0, "Damrith SOm", "damrith.som@example.com", "555-1234");
        myAccount.performTransactions();
    }
}