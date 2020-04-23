package Models.Card;

import java.sql.Date;

public class DebitCard extends Card {
    private String bank;

    public DebitCard(int id, String number, Date exp, int cvc, String bank) {
        super(id, number, exp, cvc);
        this.bank = bank;
    }

    public DebitCard(String number, Date exp, int cvc, String bank) {
        super(number, exp, cvc);
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
