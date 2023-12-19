import java.util.Scanner;

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
            return true;
        }
    }
}

class ATM {
    private Account userAccount;

    public ATM(Account userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, double amount) {
        switch (choice) {
            case 1:
                userAccount.withdraw(amount);
                break;
            case 2:
                userAccount.deposit(amount);
                System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                break;
            case 3:
                System.out.println("Current Balance: " + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

public class program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();

        Account userAccount = new Account(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            if (choice == 4) {
  
                break;
            }

            System.out.print("Enter transaction amount: ");
            double amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a non-negative value.");
                continue;
            }

            atm.performTransaction(choice, amount);
        }

        scanner.close();
    }
}