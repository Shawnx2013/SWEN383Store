package Models.Account;

import Models.Card.Card;
abstract class Account {

    protected int id;
    protected String name;
    protected String password;
    protected String address;
    protected String home;
    protected String mobile;
    protected String email;
    protected int custID;

    protected Card card;

    public Account(int id, String email, String password, String name, String address, String home, String mobile, Card card){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.card = card;
    }
    public Account(int id,String email,String password,String name,String address,String home,String mobile){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
    }
    public Account(String email, String password, String name, String address, String home, String mobile){
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return home;
    }

    public String getMobilePhone() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public int getCustID() {
        return custID;
    }

    public Card getCard() { return this.card; }

    public void setCard(Card card) { this.card = card; }

    public void setName(String name) {
        this.name = name;
    }

    public void setHomeAddr(String homeAddr) {
        this.address = homeAddr;
    }

    public void setHomePhone(String homePhone) {
        this.home = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobile = mobilePhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

}
