//Name: Khalil Gayle    Student Number: 301170285

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransactionTest {

    public static void main(String[] args) throws InterruptedException {

        Account sharedAccount = new Account("Masai Ujiri");

        Transaction t1 = new Transaction(sharedAccount, TransactionType.WITHDRAW, 200);
        Transaction t2 = new Transaction(sharedAccount, TransactionType.DEPOSIT, 1000);
        Transaction t3 = new Transaction(sharedAccount, TransactionType.DEPOSIT, 500);
        Transaction t4 = new Transaction(sharedAccount, TransactionType.WITHDRAW, 100);

        System.out.println("Performing transactions");
        System.out.println("----------------------------------------------------------------");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.shutdown();

        if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {

            System.out.println(sharedAccount.toString());
            System.out.println("SharedAccount  : " + sharedAccount);

        }




    }

}
