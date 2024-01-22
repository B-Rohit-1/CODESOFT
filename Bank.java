import java.util.*;
class BankAccount {
    private double balance;

    public BankAccount(double initBal) {
        this.balance = initBal;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

class Atm {
    private BankAccount bankAccount;
    public Atm(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("0. Exit");
    }

    public void prfmTrans(int choice, double amount) {
        switch (choice) {
            case 1:
                bankAccount.withdraw(amount);
                break;
            case 2:
                bankAccount.deposit(amount);
                break;
            case 3:
                System.out.println("Current Balance: $" + bankAccount.getBalance());
                break;
            case 0:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter initial balance for your bank account:");
        double initBal = sc.nextDouble();
        BankAccount userAccount = new BankAccount(initBal);
        Atm atm = new Atm(userAccount);
        while (true) {
            atm.displayOptions();
            System.out.print("Enter your choice (0-3): ");
            int choice = sc.nextInt();
            double amount = 0;

            if (choice == 0) {
                break;
            }
            if(choice == 1 || choice == 2){
                System.out.print("Enter the amount: ");
                amount = sc.nextDouble();
            }
            atm.prfmTrans(choice, amount);
        }
    }
}
