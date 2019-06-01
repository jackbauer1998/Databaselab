package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by JackSon on 22/03/2019.
 */
public class dbconn {

    public dbconn ()
    {

    }

    public static Connection dbConnectioned()
    {
        try
        {
            Connection conn = null;
            /**************************************/
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String serverName = "200.200.200.5";
            String portNumber = "1521";
            String sid = "orcl";
            String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
            String username = "gems_data_base";
            String password = "gems_data_base";
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch (Exception Error)
        {
            return null;
        }
    }

}
