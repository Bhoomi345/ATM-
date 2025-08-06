 import java.util.*;

public class ATM {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 1000.0; // initial balance
    static String transactionHistory = "";
    static String userId = "user123";
    static String userPin = "1234";

    public static void main(String[] args) {
        System.out.println(" Welcome to the ATM Interface");

        // Login
        if (login()) {
            // Show Menu
            int choice;
            do {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showTransactionHistory();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        System.out.println(" Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println(" Invalid choice. Try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println(" Incorrect User ID or PIN. Access Denied.");
        }
    }

    static boolean login() {
        System.out.print("Enter User ID: ");
        String inputId = scanner.next();
        System.out.print("Enter PIN: ");
        String inputPin = scanner.next();

        return inputId.equals(userId) && inputPin.equals(userPin);
    }

    static void showTransactionHistory() {
        System.out.println(" Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println(transactionHistory);
        }
    }

    static void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdrawn: ₹" + amount + "\n";
            System.out.println(" ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println(" Insufficient balance or invalid amount.");
        }
    }

    static void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            transactionHistory += "Deposited: ₹" + amount + "\n";
            System.out.println(" ₹" + amount + " deposited successfully.");
        } else {
            System.out.println(" Invalid amount.");
        }
    }

    static void transfer() {
        System.out.print("Enter recipient's account ID: ");
        String recipient = scanner.next();
        System.out.print("Enter amount to transfer: ₹");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Transferred ₹" + amount + " to " + recipient + "\n";
            System.out.println(" ₹" + amount + " transferred to " + recipient + " successfully.");
        } else {
            System.out.println(" Insufficient balance or invalid amount.");
 }
}
}
