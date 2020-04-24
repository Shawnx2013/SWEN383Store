package Models.Account;

import Models.Card.Card;

public class Customer extends Account {
    private String state;
    private String city;
    private String zip;

    public Customer(int id, String email, String password, String name, String address, String home, String mobile, Card card) {
        super(id, email, password, name, address, home, mobile, card);
    }

    public Customer(int id, String email, String password, String name, String address, String home, String mobile) {
        super(id, email, password, name, address, home, mobile);
    }

    public Customer(String email, String password, String name, String address, String home, String mobile) {
        super(email, password, name, address, home, mobile);
    }

    public Customer(String email, String password, String name, String address, String city, String state, String zip, String home, String mobile){
        super(email, password, name, (address+" " +city+", " + state + " " + zip), home, mobile);
    }
}
