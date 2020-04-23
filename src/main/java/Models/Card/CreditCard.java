package Models.Card;

import java.sql.Date;

public class CreditCard extends Card {

    private String provider;
    public CreditCard(int id, String number, Date exp, int cvc, String provider){
        super(id,number,exp,cvc);
        this.provider = provider;

    }

    public CreditCard(String number, Date exp, int cvc, String provider) {
        super(number, exp, cvc);
        this.provider = provider;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
