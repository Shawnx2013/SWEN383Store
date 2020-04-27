package Models.Item;

public abstract class Item{

    protected int availableAmt;
    protected String name;

    public Item(String name, int amt){
        this.availableAmt = amt;
        this.name = name;
    }
    public int getAvailableAmt(){return availableAmt;}

    public String getName(){return name;};

    public void setAvailableAmt(int availableAmt){this.availableAmt = availableAmt;}

    public void setName(String name){this.name = name;}
}