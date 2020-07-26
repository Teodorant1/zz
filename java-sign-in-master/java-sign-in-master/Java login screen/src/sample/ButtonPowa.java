package sample;

import java.sql.*;
import java.util.Properties;

public class ButtonPowa implements ButtonActions {

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public static Object getUserName() {
        return userName;
    }

    public static Object getPassword() {
        return password;
    }

    public static Object userName;
    public static Object password;
    public String dbms = "1";
    public String serverName = "1";
    public String portNumber = "1";
    public String dbName = "1";

    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                            this.serverName +
                            ":" + this.portNumber + "/",
                    connectionProps);
        } else if (this.dbms.equals("derby")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":" +
                            this.dbName +
                            ";create=true",
                    connectionProps);
        }
        System.out.println("Connected to database");
        return conn;
    }

    public static void viewTable(Connection con, String dbName) throws SQLException {

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
