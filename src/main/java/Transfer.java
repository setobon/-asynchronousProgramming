public class Transfer {

    private double balance = 1000000;

    public double balance(){
        return this.balance;
    }

    public Response transferMoney(double amount){
        if(amount > balance){
            return new Response("001","insufficient balance");
        }
        return new Response("000","Success transfer for COP $" +amount);
    }
}
