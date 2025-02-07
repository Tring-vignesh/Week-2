// Custom Exception for Invalid name 
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}
// Custom Exception for Invalid pin
class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Amount
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
//This Class Implement Bank Account
class BankAccount {
    private int accountNumber;
    private String name;
    private double balance;
    private int atmPin;
    public BankAccount(int accountNumber, String name, int atmPin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.atmPin = atmPin;
    }
    //Method to deposit money
    public void deposit(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Amount cannot be negative.");
        }
        this.balance += amount;
        System.out.println(amount + " deposited in " + accountNumber + " account.");
    }
    //Method to withdraw
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount < 0) {
            throw new InvalidAmountException("Amount cannot be negative.");
        }
        if (this.balance < amount) {
            throw new InsufficientBalanceException("Insufficient Balance! Your Balance is: " + this.balance + ". You cannot withdraw " + amount);
        }
        this.balance -= amount;
        System.out.println(amount + " withdrawn from account " + accountNumber + ".");
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
