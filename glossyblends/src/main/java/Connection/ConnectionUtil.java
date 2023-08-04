package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

    public static Connection getConnection()  {
        Connection con = null;
        String url ="jdbc:mysql://localhost:3306/Glossy_Blends_Artist";
        String userName = "root";
        String passWord = "123456";
        try {
            con = (Connection) DriverManager.getConnection(url, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
        return con;
    }
}
