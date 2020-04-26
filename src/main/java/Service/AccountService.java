package Service;

import Models.Account.Customer;
import Models.Account.Registration;
import Core.Database;
import com.sun.source.tree.ParenthesizedTree;
import util.ParseRequestBody;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountService {
    Registration registration;
    Database db = new Database();
    public AccountService(Registration registration){
        this.registration = registration;
    }

    public int addCustomer(){
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

}
