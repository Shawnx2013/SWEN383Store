package Models.Card;

import java.sql.Date;

public abstract class Card {

    private int id;
    private String number;
    private Date exp;
    private int cvc;

    public Card(int id, String number, Date exp, int cvc){
        this.id = id;
        this.number = number;
        this.exp = exp;
        this.cvc = cvc;
    }
    public Card(String number, Date exp, int cvc){
        this.number = number;
        this.exp = exp;
        this.cvc = cvc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}