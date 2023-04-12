import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQLConnect extends Thread{

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "12345";
    private static final String DBURL = "jdbc:mysql://localhost:3306/pz7";

    private static Connection connection;

    protected static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(DBURL, USER, PASS);
                connection.setAutoCommit(true);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage() + " " + e.getClass());
                throw new RuntimeException("DB NOT CONNECT");
            }
        }

        return connection;
    }


}
