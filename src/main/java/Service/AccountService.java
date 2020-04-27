package Service;

import Models.Account.Customer;
import Models.Account.Registration;
import Core.Database;
import com.sun.source.tree.ParenthesizedTree;
import util.ParseRequestBody;

import java.sql.*;

public class AccountService {
    Registration registration;
    Database db = new Database();
    public AccountService(){

    }

    public int addCustomer(Registration registration){
        boolean bool = true;
        Customer cust = new Customer(registration.getEmail(), registration.getPassword(), registration.getName(),
                            registration.getAddress(), registration.getCity(), registration.getState(), registration.getZip(),
                            registration.getHomePhone(), registration.getMobilePhone());
        if(db.connect()){
            try {
                CallableStatement cs = db.conn.prepareCall("{CALL CREATE_CUSTOMER (?,?,?,?,?,?)}");
                cs.setString(1, cust.getEmail());
                cs.setString(2, cust.getPassword());
                cs.setString(3, cust.getName());
                cs.setString(4, cust.getAddress());
                cs.setString(5, cust.getHomePhone());
                cs.setString(6, cust.getMobilePhone());

                int rows = cs.executeUpdate();

                db.close();

                return rows;
            }
            catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
        return -1;
    }

    public String[] getAccount(String email, String password){
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

                cs.executeQuery();
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
        }
        return null;
    }

}
