//This Class Implement Bank Account

class BankAccount {

    private int accountNumber;
    private String name;
    private double balance;
    private int atmPin;

    public BankAccount(int accountNumber, String name, double balance, int atmPin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.atmPin = atmPin;
    }

    //Method to deposit money
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Amount cannot be negative");
        } else {
            this.balance += amount;
            System.out.println(amount + " deposited in " + accountNumber + " account");
        }
    }

    //Method to withdraw
    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Amount cannot be negative");
        } else if (this.balance < amount) {
            System.out.println("Insufficient Balance!!!.Your Balance is :" + this.balance + " You cannot withdraw " + amount);
        } else {
            this.balance -= amount;
        }
    }

    //Method to display balance
    public void displayBalance() {
        System.out.println("Dear " + this.name + ",");
        System.out.println("Your Account number is : " + accountNumber);
        System.out.println("Your Account Balance is : " + balance);
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAtmPin() {
        return atmPin;
    }
}
