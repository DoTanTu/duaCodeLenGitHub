
package managerbook.Dao;
import java.sql.*;

public class ConnectionJDBC {
    public static Connection connectionJDBC(){
        final String URL = "jdbc:sqlserver://localhost;database=ManagerProduct";
        final String USER = "sa";
        final String PASS = "sa123";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
    