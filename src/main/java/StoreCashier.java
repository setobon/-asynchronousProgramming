public class StoreCashier {

    private String nameCashier;

    public StoreCashier(String nameCashier) {
        this.nameCashier = nameCashier;
    }

    public void buy(Customer customer, long timeStamp){
        System.out.println("The cashier "
                + this.nameCashier
                + " the begins to process the purchase of the customer "
                + customer.getName()
                + " in the time "
                + (System.currentTimeMillis()-timeStamp)/1000
                + " seconds");

        for (int i = 0; i < customer.getShoppingCar().length; i++){
            this.waitBySeconds(customer.getShoppingCar()[i]);
            System.out.println("The product processed "
                    + (i+1)
                    + " -- seconds: "
                    + (System.currentTimeMillis()-timeStamp)/1000);
        }

        System.out.println("The cashier "
                + this.nameCashier
                + " has finished processing "
                + customer.getName()
                + " in the time: "
                + (System.currentTimeMillis()-timeStamp)/1000);

    }

    private void waitBySeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException exception){
            Thread.currentThread().interrupt();
        }
    }
}
