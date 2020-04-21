package Report;

public class InvReport extends Report{
    private int currentOwned;
    private int currentRent;
    private int onHold;
    private int currentStock;
    private int pendingReserv;
    private int itemId;
    public InvReport(int itemId){
        this.itemId = itemId;
    }
    public int getCurrentOwned(){
        return currentOwned;
    }

    public int getCurrentRent(){ return currentRent; }

    public int getOnHold(){ return onHold; };

    public int getCurrentStock() {return  currentStock;}

    public int getPendingReserv() {return  pendingReserv;}
}
