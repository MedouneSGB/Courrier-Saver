package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSGB
 */
public class NewClass {

    DefaultTableModel dt;
    Connection conn = new Connect().connect();

    public void selectAll() {
        String sql = "SELECT * FROM departs";
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t"
                        + rs.getString(5) + "\t"
                        + rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //String name, double capacity
    public void insert() {
        String sql = "INSERT INTO departs(id, objet, expediteur, destinataire, date, time) VALUES(NULL,?,?,?,date('now'),time('now'))";

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "test2");
            pstmt.setString(2, "test2");
            pstmt.setString(3, "test2");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        NewClass app = new NewClass();
        app.insert();
        app.selectAll();
    }

}
