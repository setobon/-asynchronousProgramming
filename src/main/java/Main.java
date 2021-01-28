import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.jcabi.aspects.Async;

import java.util.concurrent.*;
import java.util.function.LongToIntFunction;

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

   /*------------------------------------------------------------------------------------*/

   /**
    * example transfer with CompletableFuture.supplyAsync
    *
    * public static void main(String[] args) throws ExecutionException, InterruptedException {

       Transfer transfer = new Transfer();
       double amount = 300000;

       CompletableFuture<Boolean> transferValue =
               CompletableFuture.supplyAsync(() -> transfer.transferMoney(amount));

       while (!transferValue.isDone()){
           System.out.println("transfer is not finished");
       }

       boolean resultTransfer = transferValue.get();
       System.out.println("Transfer is finished " + resultTransfer);
   }*/

   /*------------------------------------------------------------------------------------*/


   /**
   guavaFuture

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      int number = 10;

      MathematicsOperations mathematicsOperations = new MathematicsOperations();
      ExecutorService threadPool = Executors.newCachedThreadPool();
      ListeningExecutorService service = MoreExecutors.listeningDecorator(threadPool);

      ListenableFuture<Long> guavaFuture = service.submit(()->mathematicsOperations.factorial(number));

      long result = guavaFuture.get();

      System.out.println("Result is "+ result );

      threadPool.shutdown();
   }*/

   /*------------------------------------------------------------------------------------*/


   /**
    *
    * EA
    *
    public static void main(String[] args) {

      int number = 10;

      MathematicsOperations mathematicsOperations = new MathematicsOperations();
      CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.factorial(number));

      long result = Async.await(completableFuture);
      System.out.println("The result is "+result);
   }

   static{
      Async.init();
   }*/


   /*------------------------------------------------------------------------------------*/

   /**
    * CACTOOS
    *
   public static void main(String[] args) throws ExecutionException, InterruptedException {
      int number = 10;

      MathematicsOperations mathematicsOperations = new MathematicsOperations();

      Async<Integer, Long> asyncFunction =
              new Async<Integer, Long>(input -> mathematicsOperations.factorial(input));
      Future<Long> asyncFuture = asyncFunction.apply(number);

      long result = asyncFuture.get();

      System.out.println("Result is " + result);
   }
    */

 /*  @Async
   public static void main(String[] args) throws ExecutionException, InterruptedException {
      int number = 10;

      MathematicsOperations mathematicsOperations = new MathematicsOperations();

      Future<Long> factorialFuture =
              CompletableFuture.completedFuture(mathematicsOperations.factorial(number));

      System.out.println(factorialFuture.get());
   }*/

   /*
   EJEMPLO Aspect

   @Async
   public static void main(String[] args) throws ExecutionException, InterruptedException {
      Transfer transfer = new Transfer();
      double amount = 300000;

      Future<Response> factorialFuture =
              CompletableFuture.completedFuture(transfer.transferMoney(amount));

      System.out.println("status: "+ factorialFuture.get().getStatus()
              + " -- Message: " + factorialFuture.get().getMessage());
   }*/


   /**
    * THREAD
    *
    * public static void main(String[] args) {
       Thread[] threads = new Thread[20];

       for(int i=0; i < threads.length; i++){
           threads[i] = new MyThread("Thread "+i);
       }

       for(int i=0; i < threads.length; i++){
           threads[i].start();
           System.out.println(threads[i].getName());
       }

   }*/


    /**
    *
    *
    * public static void main(String[] args) {
       MyThread myThread = new MyThread();

       new Thread(myThread).start();
    }*/


    public static void main(String[] args) {


        Customer customer1 = new Customer("Sara", new int[]{2, 2, 1, 5, 2, 3});
        Customer customer2 = new Customer("Harry", new int[]{4, 1, 4, 1, 1});

        StoreCashier storeCashier1 = new StoreCashier("Andres");
        StoreCashier storeCashier2 = new StoreCashier("Andres");

        long initialTime = System.currentTimeMillis();

        storeCashier1.buy(customer1, initialTime);
        storeCashier2.buy(customer2, initialTime);

    }
}
