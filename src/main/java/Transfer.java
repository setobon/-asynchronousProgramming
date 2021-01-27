public class Transfer {

    private double balance = 1000000;

    public double balance(){
        return this.balance;
    }

    public boolean transferMoney(double amount){
        if(amount > balance){
            System.out.println("insufficient balance");
            return false;
        }
        System.out.println("Success transfer for COP $" +amount);
        return true;
    }
}
