public class MainRunnable implements Runnable{

    /*private StoreCashier storeCashier;
    private Customer customer;*/
    private StadiumEntrance stadiumEntrance;
    private Entry entry;
    private long initialTime;

    /*public MainRunnable(StoreCashier storeCashier, Customer customer, long initialTime) {
        this.storeCashier = storeCashier;
        this.customer = customer;
        this.initialTime = initialTime;
    }*/

    public MainRunnable(StadiumEntrance stadiumEntrance, Entry entry, long initialTime) {
        this.stadiumEntrance = stadiumEntrance;
        this.entry = entry;
        this.initialTime = initialTime;
    }
    @Override
    public void run(){
        this.stadiumEntrance.totalEntrances(this.entry, this.initialTime);
    }


    public static void main(String[] args) {
        Entry entry1 = new Entry("001", new int[]{2, 2, 1, 5, 2, 3});
        Entry entry2 = new Entry("002", new int[]{4, 1, 4, 1, 1});

        StadiumEntrance stadiumEntrance1 = new StadiumEntrance("Oriental");
        StadiumEntrance stadiumEntrance2 = new StadiumEntrance("Occidental");

        long initialTime = System.currentTimeMillis();

        Runnable processOne = new MainRunnable(stadiumEntrance1, entry1, initialTime);
        Runnable processTwo = new MainRunnable(stadiumEntrance2, entry2, initialTime);

        new Thread(processOne).start();
        new Thread(processTwo).start();
    }

    /**
     *
     *

    public static void main(String[] args) {
        Customer customer1 = new Customer("Sara", new int[]{2, 2, 1, 5, 2, 3});
        Customer customer2 = new Customer("Harry", new int[]{4, 1, 4, 1, 1});

        StoreCashier storeCashier1 = new StoreCashier("Andres");
        StoreCashier storeCashier2 = new StoreCashier("Andres");

        long initialTime = System.currentTimeMillis();

        Runnable processOne = new MainRunnable(storeCashier1, customer1, initialTime);
        Runnable processTwo = new MainRunnable(storeCashier2, customer2, initialTime);

        new Thread(processOne).start();
        new Thread(processTwo).start();
    }
     */
}
