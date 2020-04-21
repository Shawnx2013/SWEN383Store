package Database;
import java.sql.*;
public class Database {
    private Connection conn;
    private String dbName;
    private final String DRIVER;
    private final String URI;
    private final String USER;
    private final String SERVER = "localhost:3306";

    private String password;

    public Database(String dbname, String user, String pw){
        dbName = dbname;
        USER = user;
        /* URL example
        "jdbc:mysql://" +
        this.serverName +":" + this.portNumber + "/" + this.dbName;
         */
        URI = "jdbc:mysql://"+SERVER+"/"+dbName+
                "?autoReconnect=true&useSSL=false&useUnicode=true&"+
                "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        DRIVER = "com.mysql.cj.jdbc.Driver";
        password = pw;
    }

    public boolean connect(){
        conn = null;
        try{
            Class.forName(DRIVER);
        }
        catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            return false;
        }
        try{
            conn = DriverManager.getConnection(URI, USER, password);
            return true;
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }

    public boolean close(){
        try{
            if(!conn.isClosed()){
                conn.close();
                System.out.println("Database Disconnected");
                return true;
            }
            else{
                System.out.println("Connection was not opened");
                return false;
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }
}
