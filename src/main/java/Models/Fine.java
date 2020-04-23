package Models;

public class Fine {

    private Rental rental;
    private double amount;
    private Payment payment;

    public Fine(Rental rental,double amount, Payment payment){
        this.rental = rental;
        this.amount = amount;
        this.payment = payment;
    }
    public Fine(Rental rental,double amount){
        this.rental = rental;
        this.amount = amount;
        this.payment = null;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean paid(){
        boolean paid = false;
        if(this.payment != null){
            paid = true;
        }
        return paid;
    }
}
