import java.util.Scanner;

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables for user details
        String accountHolderName;
        int accountNumber;
        double balance = 0;

        // Welcome Message
        System.out.println("===== Welcome to XYZ Bank =====");

        // Taking user input for account creation
        System.out.print("Enter Account Holder Name: ");
        accountHolderName = sc.nextLine();

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextInt();

        // Initial deposit (optional)
        System.out.print("Do you want to make an initial deposit? (1 for Yes, 0 for No): ");
        int choice = sc.nextInt();

        balance = (choice == 1)
                ? depositAmount(sc)
                : 0; // Ternary operator used here

        // Displaying account details
        System.out.println("\nAccount created successfully!");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);

        // Loop for user actions
        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();

            // Handling user choices using conditional statements
            if (option == 1) {
                balance = depositAmount(sc); // Deposit operation
            } else if (option == 2) {
                balance = withdrawAmount(sc, balance); // Withdrawal operation
            } else if (option == 3) {
                System.out.println("Current Balance: ₹" + balance);
            } else if (option == 4) {
                System.out.println("Thank you for using XYZ Bank! Goodbye!");
                break; // Exit loop
            } else {
                System.out.println("Invalid choice. Please try again!");
            }

            // Logical operator used to prevent negative balance
            if (balance < 0) {
                System.out.println("Warning: Your balance is negative!");
            }
        }

        sc.close(); // Close the scanner
    }

    // Method to handle deposits
    public static double depositAmount(Scanner sc) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        // Ensure amount is positive using logical operator
        if (amount > 0) {
            System.out.println("₹" + amount + " deposited successfully!");
            return amount;
        } else {
            System.out.println("Invalid deposit amount! Must be greater than zero.");
            return 0;
        }
    }

    // Method to handle withdrawals
    public static double withdrawAmount(Scanner sc, double currentBalance) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        // Ensure sufficient balance and positive withdrawal amount
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount; // Arithmetic operator used here
            System.out.println("₹" + amount + " withdrawn successfully!");
        } else if (amount > currentBalance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }

        return currentBalance;
    }
}
