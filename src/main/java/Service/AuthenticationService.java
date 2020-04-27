package Service;

import Core.Database;
import Models.Account.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class AuthenticationService {
    private String email, password;
    Database db = new Database();
    public AuthenticationService(String email, String password){
        this.email = email;
        this.password = password;
    }

    public boolean login(){
        if(db.connect()){
            try{
                CallableStatement cs = db.conn.prepareCall("{CALL RETRIEVE_EMAIL_PASSWORD(?,?,?,?)}");
                cs.setString(1,email);
                cs.setString(2,password);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.registerOutParameter(4, Types.VARCHAR);

                ResultSet rs = cs.executeQuery();
                String out_email = cs.getString(3);
                String out_password = cs.getNString(4);

                System.out.println("Calling retrieve_email_password: " + out_email + ", " + out_password);

                if(out_email != null)
                    return true;
                else
                    return false;
            }
            catch(SQLException sqle){
                sqle.printStackTrace();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
