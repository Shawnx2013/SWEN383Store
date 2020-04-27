package Service;

import Core.Database;
import Models.Item.*;

import java.util.*;
import java.sql.*;

public class ItemService {
    Database db = new Database();
    public ItemService(){

    }
    public Object getItemByType(String type){
        if(db.connect()){
            try {
                CallableStatement cs = db.conn.prepareCall("{CALL RETRIEVE_ITEM_BY_TYPE(?)}");

                if (type.equals("dvd")) {
                    return getMovie(cs);
                }
                if (type.equals("cd")) {
                    return getGame(cs);
                }
            }
            catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<Movie> getMovie(CallableStatement cs) throws SQLException {
        cs.setString(1,"MovieDVD");
        ResultSet rs = cs.executeQuery();
        ArrayList<Movie> list = new ArrayList<Movie>();
        while(rs.next()){
            String name = rs.getString("item_name");
            int amt = rs.getInt("item_amt");
            list.add(new Movie(name, amt));
        }
        return list;
    }

    public ArrayList<Game> getGame(CallableStatement cs) throws SQLException {
        cs.setString(1,"GameCD");
        ResultSet rs = cs.executeQuery();
        ArrayList<Game> list = new ArrayList<Game>();
        while(rs.next()){
            String name = rs.getString("item_name");
            int amt = rs.getInt("item_amt");
            list.add(new Game(name, amt));
        }
        return list;
    }
}
