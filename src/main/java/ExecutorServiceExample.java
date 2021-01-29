import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Executors:
 *
 * 1. FixedThreadPoolExecutor  -> Ejecutor de grupo de subprocesos fijos
 * 2. SingleThreadPoolExecutor -> Ejecutor de grupo de suprocesos únicos
 * 3. ChacheThreadPoolExecutor -> Ejecutor de grupo de subprocesos en caché
 */
public class ExecutorServiceExample {

    public static void main(String[] args) {
        //fixedThreadPoolExecutor();
        //singleThreadPoolExecutor();
        //cacheThreadPoolExecutor();
        example();
    }

    private static void example() {
        System.out.println("The thread started");

        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0, 40).forEach(i -> executors.execute(()->sum(i, i*3)));
        executors.shutdown();

        System.out.println("The thread finish");
    }


    private static void cacheThreadPoolExecutor() {
        System.out.println("The thread started");

        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach(i -> executors.execute(()->showNameThread()));
        executors.shutdown();

        System.out.println("The thread finish");
    }

    private static void singleThreadPoolExecutor() {
        System.out.println("The thread started");

        ExecutorService executors = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).forEach(i -> executors.execute(()->showNameThread()));
        executors.shutdown();

        System.out.println("The thread finish");
    }

    private static void fixedThreadPoolExecutor() {
        System.out.println("The thread started");

        ExecutorService executors = Executors.newFixedThreadPool(3);
        IntStream.range(0, 10).forEach(i -> executors.execute(()->showNameThread()));
        executors.shutdown();

        System.out.println("The thread finish");
    }
    public static void showNameThread(){
        System.out.println("Thread name " + Thread.currentThread().getName());
    }

    public static void sum(int num1, int num2){
        System.out.println("The sum of "+ num1 +" and " + num2 + " is " + (num1+num2));
    }
}
