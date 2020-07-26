package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface ButtonActions {
    String userName = null;
    String password = null;

    void setUserName(Object userName);

    void setPassword(Object password);

    static Connection getConnection() throws SQLException {
        return null;
    }

    public static Object getUserName() {
        return userName;
    }

    public static Object getPassword() {
        return password;
    }


    static void viewTable(Connection con, String dbName) throws SQLException {

        Statement stmt = null;
        String query = "select USERNAME " + "PASSWORD " + "from " + dbName + ".USERINFO WHERE password = " + ButtonPowa.getPassword() + "AND username =" + ButtonPowa.getUserName();
        //not sure how attach these to buttons and also not sure what mysql returns if it finds something
        // I also don't know what my custom exception should look like
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println(username + "\t" + password);
            }
        } catch (SQLException e ) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
