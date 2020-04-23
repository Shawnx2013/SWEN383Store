package Models.Account;

import Models.Card.Card;

public class Manager extends Account {
    public Manager(int id, String email, String password, String name, String address, String home, String mobile, Card card) {
        super(id, email, password, name, address, home, mobile, card);
    }

    public Manager(int id, String email, String password, String name, String address, String home, String mobile) {
        super(id, email, password, name, address, home, mobile);
    }

    public Manager(String email, String password, String name, String address, String home, String mobile) {
        super(email, password, name, address, home, mobile);
    }
}
