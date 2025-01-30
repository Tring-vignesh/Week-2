
import java.util.*;

public class BankSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n********************** BANK SYSTEM ****************");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit amount: ");
                    double initialDeposit = scanner.nextDouble();
                    BankAccount newAccount = new BankAccount(accounts.size(), name, initialDeposit);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully! Your Account Number is: " + (accounts.size() - 1));
                    break;
                case 2:
                    System.out.print("Enter your account number: ");
                    int accNumber = scanner.nextInt();
                    if (accNumber >= 0 && accNumber < accounts.size()) {
                        BankAccount currentAccount = accounts.get(accNumber);
                        int subChoice;
                        do {
                            System.out.println("\n********** Welcome, " + currentAccount.getName() + " **********");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("0. Logout");
                            System.out.print("Enter your choice: ");
                            subChoice = scanner.nextInt();
                            switch (subChoice) {
                                case 1:
                                    System.out.print("Enter deposit amount: ");
                                    double depositAmount = scanner.nextDouble();
                                    currentAccount.deposit(depositAmount);
                                    break;
                                case 2:
                                    System.out.print("Enter withdrawal amount: ");
                                    double withdrawAmount = scanner.nextDouble();
                                    currentAccount.withdraw(withdrawAmount);
                                    break;
                                case 3:
                                    currentAccount.displayBalance();
                                    break;
                                case 0:
                                    System.out.println("Logged out");
                                    break;

                                default:
                                    System.out.println("Invalid choice! Please try again.");
                            }
                        } while (subChoice != 0);

                    } else {
                        System.out.println("Invalid account number!");
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using our bank system!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }
}
