abstract class Bank {
    int accountNumber;
    double balance;

    abstract void deposit(int amount);
    abstract void withdraw(int amount);
}

class SavingAccount extends Bank {
    
    SavingAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    @Override
    void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal");
        }
    }
}

public class BankManagement {
    public static void main(String[] args) {
        SavingAccount account = new SavingAccount(12345, 1000.0);
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(1500);
    }
}
