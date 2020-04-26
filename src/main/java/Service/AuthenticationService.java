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

    public String[] login(){
        if(db.connect()){
            try{
                CallableStatement cs = db.conn.prepareCall("{CALL RETRIEVE_ACCOUNT_BY_LOGIN(?,?,?,?,?,?,?,?,?)}");
                cs.setString(1,email);
                cs.setString(2,password);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.registerOutParameter(4, Types.VARCHAR);
                cs.registerOutParameter(5, Types.VARCHAR);
                cs.registerOutParameter(6, Types.VARCHAR);
                cs.registerOutParameter(7, Types.VARCHAR);
                cs.registerOutParameter(8, Types.VARCHAR);
                cs.registerOutParameter(9, Types.VARCHAR);

                ResultSet rs = cs.executeQuery();
                String out_email = cs.getString(3);
                String out_password = cs.getNString(4);
                String name = cs.getString(5);
                String address = cs.getString(6);
                String home = cs.getString(7);
                String mobile = cs.getString(8);
                String role = cs.getString(9);

                System.out.println("Calling retrieve_account_by_login: " + out_email + ", " + out_password + ", " + name + ", " +
                                    address + ", " + home + ", " + mobile + ", " + role);
                if(out_email != null)
                    return new String[]{out_email, out_password, name, address, home, mobile, role};
                else
                    return new String[]{};
            }
            catch(SQLException sqle){
                sqle.printStackTrace();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
