package Models.Item;

public abstract class Item{

    protected int availableAmt;
    protected int itemId;
    protected double rate;
    protected String name;

    public Item(int id,String name){
        this.itemId = id;
        this.name = name;
    }
    public int getAvailableAmt(){return availableAmt;}

    public int getItemId(){return itemId;}

    public double getRate(){return rate;}

    public void setAvailableAmt(int availableAmt){this.availableAmt = availableAmt;}

    public void setItemId(int itemId){this.itemId = itemId;}

    public void setRate(double rate){this.rate = rate;}

}