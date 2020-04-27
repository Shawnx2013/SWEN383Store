package Service;

import Core.Database;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class ItemService {
    Database db = new Database();
    public ItemService(){

    }
    public String[] getItemByType(String type){
        if(db.connect()){
            try {
                CallableStatement cs = db.conn.prepareCall("{CALL RETRIEVE_ITEM_BY_TYPE(?)}");
                cs.setString(1, type);

                ResultSet rs = cs.executeQuery();

                while(rs.next()){

                }
            }
            catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        return null;
    }
}
