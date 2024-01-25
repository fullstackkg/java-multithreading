//Name: Khalil Gayle    Student Number: 301170285

import java.text.DecimalFormat;

public class Account {
    //Account class that we'll use to create instances of accounts to test multithreading abilities
    private final String ownerName;
    private double balance = 1000;
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public Account(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Account {owner name: " + this.ownerName +
                ", " + "balance: $" + decimalFormat.format(this.balance) + "}";
    }

    //This method will "synchronize" the transaction type so only one thread can access it at a time
    public synchronized void performTransaction(TransactionType transactionType, double transactionAmount) {

        if (transactionType == TransactionType.DEPOSIT) {
            System.out.println(this);
            balance = transactionAmount + this.balance;
            System.out.println("Attempting to deposit $" + decimalFormat.format(transactionAmount) + " to " + ownerName + "'s account");
            System.out.println("Successfully deposited $" + decimalFormat.format(transactionAmount) + " to " + ownerName + "'s account");
            System.out.println("----------------------------------------------------------------");

        } else if (transactionType == TransactionType.WITHDRAW){

            if (transactionAmount < this.balance){

                System.out.println(this);
                this.balance -= transactionAmount;
                System.out.println("Attempting to withdraw $" + decimalFormat.format(transactionAmount) + " from " + ownerName + "'s account");
                System.out.println("Successfully withdrawn $" + decimalFormat.format(transactionAmount) + " from " + ownerName + "'s account");
                System.out.println("----------------------------------------------------------------");


            } else {

                System.out.println(this);
                System.out.println("Attempting to withdraw $" + decimalFormat.format(transactionAmount) + " from " + ownerName + "'s account");
                System.out.println("Invalid amount, this amount exceeds balance");
                System.out.println("----------------------------------------------------------------");

            }

        }

    }
}
