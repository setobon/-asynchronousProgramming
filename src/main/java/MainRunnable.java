import java.util.concurrent.Executor;

public class MainRunnable{
    private StoreCashier storeCashier;
    private Customer customer;
    private long initialTime;

    public MainRunnable(StoreCashier storeCashier, Customer customer, long initialTime) {
        this.storeCashier = storeCashier;
        this.customer = customer;
        this.initialTime = initialTime;
    }

    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();

        Customer customer = new Customer("Sergio",new int[]{2,2,1,5,2,3});
        Customer customer2 = new Customer("Tobon",new int[]{4,1,4,1,1});

        StoreCashier storeCashier = new StoreCashier("Andres");
        StoreCashier storeCashier1 = new StoreCashier("Andres");

        Executor executor = new Invoker();

        executor.execute(()-> storeCashier.buy(customer,initialTime));
        executor.execute(()-> storeCashier1.buy(customer2,initialTime));
    }
}
