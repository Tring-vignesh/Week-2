
import java.util.*;

public class ATMSystem {
    //method to get int value only
    private static int getInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer:");
                scanner.next();
            }
        }
    }
    //method to get double value only
    private static double getDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid  amount:");
                scanner.next();
            }
        }
    }
    //method to get valid name 
    private static String getName(Scanner scanner) {
        while (true) {
            String name = scanner.nextLine().trim();
            try {
                if (name.isEmpty()) {
                    throw new InvalidNameException("Name cannot be empty. Please enter a valid name.");
                }
                if (!name.matches("[a-zA-Z ]+")) {
                    throw new InvalidNameException("Name cannot contain numbers or special characters. Please enter a valid name.");
                }
                return name;
            } catch (InvalidNameException e) {
                System.out.println("Error: " + e.getMessage()); 
            }
        }
    }
    
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
            choice = getInt(scanner);
            scanner.nextLine();
            switch (choice) {
                //If Users choice is 0 Exit from Atm
                case 0:
                    System.out.println("Thank you for using our ATM system.");
                    break;
                //To Create new Account
                case 1:
                    System.out.print("Enter Your Name: ");
                    String name = getName(scanner);
                    int atmPin;
                    //validating atm pin atm pin must be four digit
                    while (true) {
                        System.out.print("Choose Four Digit ATM Pin: ");
                        try {
                            atmPin = getInt(scanner);
                            if (atmPin < 1000 || atmPin > 9999) {
                                throw new InvalidPinException("Invalid PIN! Please choose a four-digit PIN.");
                            }
                            break;
                        } catch (InvalidPinException e) {
                            System.out.println("Invalid Pin : " + e.getMessage());
                        } 
                    }
                    //create new Account
                    BankAccount newAccount = new BankAccount(accounts.size(), name, atmPin);
                    double initialDeposit;
                    while (true) {
                        System.out.print("Enter Your Initial Deposit Amount: ");
                        try {
                            initialDeposit = getDouble(scanner);
                            newAccount.deposit(initialDeposit);
                            //Add new Account to accounts
                            accounts.add(newAccount);
                            System.out.println("New Account Created Successfully! Your Account Number is: " + (accounts.size() - 1));
                            break;
                        } catch (InvalidAmountException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid numeric amount.");
                            scanner.next();
                        }
                    }

                    break;
                //If Customer has Acccount
                case 2:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = getInt(scanner);
                    System.out.print("Enter Your ATM Pin: ");
                    int pin = getInt(scanner);
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
                            subChoice = getInt(scanner);
                            try {
                                switch (subChoice) {
                                    case 1:
                                        System.out.print("Enter Deposit Amount: ");
                                        double depositAmount = getDouble(scanner);
                                        foundAccount.deposit(depositAmount);
                                        break;
                                    case 2:
                                        System.out.print("Enter Withdrawal Amount: ");
                                        double withdrawAmount = getDouble(scanner);
                                        foundAccount.withdraw(withdrawAmount);
                                        break;
                                    case 3:
                                        foundAccount.displayBalance();
                                        break;
                                    case 0:
                                        System.out.println("Logged out.");
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            } catch (InvalidAmountException | InsufficientBalanceException e) {
                                System.out.println("Error: " + e.getMessage());
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
