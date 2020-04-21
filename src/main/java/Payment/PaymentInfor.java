package Payment;

public class PaymentInfor {
    protected String cardHolder;
    protected String cardNumber;
    protected String cardBank;
    protected int securityCode;

    public void setCardBank(String cardBank) {
        this.cardBank = cardBank;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

}
