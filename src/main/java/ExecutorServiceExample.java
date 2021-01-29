import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Executors:
 *
 * 1. FixedThreadPoolExecutor  -> Ejecutor de grupo de subprocesos fijos
 * 2. SingleThreadPoolExecutor -> Ejecutor de grupo de suprocesos únicos
 * 3. ChacheThreadPoolExecutor -> Ejecutor de grupo de subprocesos en caché
 * 4. ScheduledThreadPool      -> Ejecutor de subprocesos programados
 */
public class ExecutorServiceExample {

    public static void main(String[] args) {
        //fixedThreadPoolExecutor();
        //singleThreadPoolExecutor();
        //cacheThreadPoolExecutor();
        //example();
        //basicScheduledThreadPool();
        //fixedRateScheduledThreadPool();
        delayFixedRateScheduledThreadPool();
    }

    /**
     * Los 10 segundos comienzan cuando la tarea ha terminado su ejecución
     *
     */
    private static void delayFixedRateScheduledThreadPool(){
        System.out.println("The thread started");

        ScheduledExecutorService executors = Executors.newScheduledThreadPool(1);
        IntStream.range(0, 10).forEach(
                i ->executors.scheduleWithFixedDelay(
                        ()->ExecutorServiceExample.showNameThread(), 20, 10,TimeUnit.SECONDS));

        //executors.shutdown();

        System.out.println("The thread finish");
    }

    /**
     * El periodo inicia después de los 10 segundos exactos
     */
    private static void fixedRateScheduledThreadPool(){
        System.out.println("The thread started");

        ScheduledExecutorService executors = Executors.newScheduledThreadPool(1);
        IntStream.range(0, 10).forEach(
                i ->executors.scheduleAtFixedRate(
                        ()->ExecutorServiceExample.showNameThread(), 20, 10,TimeUnit.SECONDS));

        //executors.shutdown();

        System.out.println("The thread finish");
    }


    private static void basicScheduledThreadPool(){
        System.out.println("Tfhe thread started");

        ExecutorService executors = Executors.newScheduledThreadPool(1);
        IntStream.range(0, 10).forEach(
                i ->((ScheduledExecutorService) executors).schedule(()->ExecutorServiceExample.showNameThread(), 20, TimeUnit.SECONDS));
        executors.shutdown();

        System.out.println("The thread finish");
    }

    private static void example(){
        System.out.println("The thread started");

        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0, 40).forEach(i -> executors.execute(()->sum(i, i*3)));
        executors.shutdown();

        System.out.println("The thread finish");
    }


    private static void cacheThreadPoolExecutor(){
        System.out.println("The thread started");

        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach(i -> executors.execute(()->showNameThread()));
        executors.shutdown();

        System.out.println("The thread finish");
    }

    private static void singleThreadPoolExecutor(){
        System.out.println("The thread started");

        ExecutorService executors = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).forEach(i -> executors.execute(()->showNameThread()));
        executors.shutdown();

        System.out.println("The thread finish");
    }

    private static void fixedThreadPoolExecutor(){
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
