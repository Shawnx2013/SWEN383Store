package Models.Item;

public class Movie extends Item{

    private String title;

    public Movie(String name, int amt){
        super(name, amt);
        title = name;
    }

}