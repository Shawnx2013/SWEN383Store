package Payment;

public class CC extends PaymentInfor {
    private int securityCode;

    public int getSecurityCode() {
        return securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

}
