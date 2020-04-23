package Models;

import Models.Card.Card;

public class Payment {
    private Card card;

    public Payment(Card card){
        this.card = card;
    }
    public Payment(){
        this.card = null;
    }
    public boolean cash(){
        boolean cash = false;
        if(this.card == null){ cash = true;}
        return cash;
    }
}
