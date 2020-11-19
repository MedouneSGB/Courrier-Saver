package connect;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MSGB
 */
public class Connect {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    Connection conn;

    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:temp.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connecté à la base de donnée sqlite");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    

}
