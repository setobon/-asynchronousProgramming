import java.util.concurrent.*;

public class Main {
    /**
     * Thread example
     *
     *
    public static void main(String... args){

        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        int number = 25;
        Thread thread = new Thread(()-> {
            System.out.println("Factorial del número "
                    + number + " es " + mathematicsOperations.factorial(number));
        });
        thread.start();
    }*/
/*------------------------------------------------------------------------------------*/
   /**
    * FutureTask
    *
    *
    *
    * public static void main(String[] args) throws ExecutionException, InterruptedException {
        int number = 10;

        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<Long> futureTask = threadPool.submit(() -> mathematicsOperations.factorial(number));

        while(!futureTask.isDone()){
            System.out.println("futureTask is not finished");
        }

        long result = futureTask.get();
        System.out.println("The result is " + result);

        threadPool.shutdown();
    }*/

   /*------------------------------------------------------------------------------------*/


   /**
    * CompletableFuture
    *
    * public static void main(String[] args) throws ExecutionException, InterruptedException {
       int number = 10;

       MathematicsOperations mathematicsOperations = new MathematicsOperations();
       CompletableFuture<Long> completableFuture =
               CompletableFuture.supplyAsync(() -> mathematicsOperations.factorial(number));

       while (!completableFuture.isDone()){
            System.out.println("completableFuture is not finished");
       }

       long result =  completableFuture.get();

       System.out.println("The result is " + result);
   }*/


   public static void main(String[] args) throws ExecutionException, InterruptedException {

       Transfer transfer = new Transfer();
       double amount = 300000;

       CompletableFuture<Boolean> transferValue =
               CompletableFuture.supplyAsync(() -> transfer.transferMoney(amount));

       while (!transferValue.isDone()){
           System.out.println("transfer is not finished");
       }

       boolean resultTransfer = transferValue.get();
       System.out.println("Transfer is finished " + resultTransfer);
   }
}
