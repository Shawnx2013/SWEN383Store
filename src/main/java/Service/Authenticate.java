package Service;

import Core.Database;

import java.sql.CallableStatement;
import java.sql.ResultSet;

public class Authenticate {
    private String email, password;
    Database db = new Database();
    public Authenticate(String email, String password){
        this.email = email;
        this.password = password;
    }

    public boolean login(String email, String password){
        /*if(db.connect()){
            try{
                CallableStatement cs =
            }
        }*/
        return true;
    }
}
