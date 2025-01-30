//This Class Implement Bank Account
class BankAccount {
    private int accountNumber;
    private String name;
    private double balance;

    public BankAccount(int accountNumber, String name, double balance) {
        setAccountNumber(accountNumber);
        setName(name);
        setBalance(balance);
    }
    //Method to deposit money
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + " deposited in " + accountNumber + " account");
    }
    //Method to withdraw
    public void withdraw(double amount) {
        if (this.balance < amount) {
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

    //Setters
    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber=accountNumber;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setBalance(double balance)
    {
        this.balance=balance;
    }
}