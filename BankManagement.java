
class Account {

    private int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

}

public class BankManagement {
    public static void main(String[] args) {
        Account account1=new Account(1, "vignesh", 1000);
        System.out.println("Name: "+account1.getName());
        System.out.println("Account Number: "+account1.getAccountNumber());
        System.out.println("Balance: "+account1.getBalance());
    }

}
