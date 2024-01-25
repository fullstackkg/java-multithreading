//Name: Khalil Gayle    Student Number: 301170285

public class Transaction implements Runnable{

    private final Account account;
    private final TransactionType transactionType;
    private final double transactionAmount;

    public Transaction(Account account, TransactionType transactionType, double transactionAmount) {

        this.account = account;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;

    }


    @Override
    public void run() {

        try {

            Thread.sleep(1000);
            account.performTransaction(transactionType, transactionAmount);

        } catch (InterruptedException e) {

            e.printStackTrace();
            Thread.currentThread().interrupt();

        }



    }
}
