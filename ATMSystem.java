
import java.util.*;
//This Class Implement ATMSystem
public class ATMSystem {

    public static void main(String[] args) {
        //Declare scanner object to getting input
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************** WELCOME TO ATM SIMULATION *********************");
        //Storing Bank Account
        ArrayList<BankAccount> accounts = new ArrayList<>();
        //Storing Users Choice
        int choice;
        do {
            System.out.println("\nEnter Your Choice: \n 1. Create New Account \n 2. Old Account \n 0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                //If Users choice is 0 Exit from Atm
                case 0:
                    System.out.println("Thank you for using our ATM system.");
                    break;
                //To Create new Account
                case 1:
                    System.out.print("Enter Your Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Your Initial Deposit Amount: ");
                    double initialDeposit = scanner.nextDouble();
                    int atmPin;
                    //validating atm pin atm pin must be four digit
                    while (true) {
                        System.out.print("Choose Four-Digit ATM Pin: ");
                        atmPin = scanner.nextInt();
                        if (atmPin >= 1000 && atmPin <= 9999) {
                            break; 
                        } else {
                            System.out.println("Invalid PIN! Please choose a four-digit PIN.");
                        }
                    }
                    //create new Account
                    BankAccount newAccount = new BankAccount(accounts.size(), name, initialDeposit, atmPin);
                    //Add new Account to accounts
                    accounts.add(newAccount);
                    System.out.println("New Account Created Successfully! Your Account Number is: " + (accounts.size() - 1));
                    break;
                //If Customer has Acccount
                case 2:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Enter Your ATM Pin: ");
                    int pin = scanner.nextInt();
                    BankAccount foundAccount = null;
                    //Validate account number & atm pin
                    if (accountNumber < accounts.size() && accounts.get(accountNumber).getAtmPin() == pin) {
                        foundAccount = accounts.get(accountNumber);
                    }
                    //if Account number or atm pin wrong
                    if (foundAccount == null) {
                        System.out.println("Invalid Account Number or ATM Pin!");
                    } else {
                        //if Correct Account number and atm pin
                        int subChoice;
                        name = foundAccount.getName();
                        //Perform operations
                        do {
                            System.out.println("\nWelcome, " + name + "! Select an option:");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("0. Logout");

                            subChoice = scanner.nextInt();

                            switch (subChoice) {
                                case 1:
                                    System.out.print("Enter Deposit Amount: ");
                                    double depositAmount = scanner.nextDouble();
                                    foundAccount.deposit(depositAmount);
                                    break;
                                case 2:
                                    System.out.print("Enter Withdrawal Amount: ");
                                    double withdrawAmount = scanner.nextDouble();
                                    foundAccount.withdraw(withdrawAmount);
                                    break;
                                case 3:
                                    foundAccount.displayBalance();
                                    break;
                                case 0:
                                    System.out.println("Logged out ");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        } while (subChoice != 0);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
