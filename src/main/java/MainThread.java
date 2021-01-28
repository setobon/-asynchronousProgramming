public class MainThread {
    public static void main(String[] args) {

        long initialTime = System.currentTimeMillis();

        Customer customer1 = new Customer("Sara", new int[]{2, 2, 1, 5, 2, 3});
        Customer customer2 = new Customer("Harry", new int[]{4, 1, 4, 1, 1});

        StoreCashierThread storeCashier1 = new StoreCashierThread("Andres", customer1, initialTime);
        StoreCashierThread storeCashier2 = new StoreCashierThread("Juan", customer2, initialTime);

        storeCashier1.start();
        storeCashier2.start();
    }
}
