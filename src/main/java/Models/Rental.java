package Models;
import Models.Item.Item;
import java.sql.Date;

public class Rental {

    private Item item;
    private Date date;
    private boolean returned;

    public Rental(Item item,Date date,boolean returned){
        this.item = item;
        this.date = date;
        this.returned = returned;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}