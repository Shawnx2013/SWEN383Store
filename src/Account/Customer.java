package Account;

public class Customer extends Acc{
    private int lateCharge;
    public Customer(String name, int id){
        this.name = name;
        this.custID = id;
    }
    public Customer(String firstname, String lastname, int id){
        this.setName(firstname, lastname);
    }

}
