import java.sql.ResultSet;
import java.sql.SQLException;

public class GetFromDb extends MySQLConnect{

    private static ResultSet executeQuery(String query) {
        try {
            return getConnection()
                    .createStatement()
                    .executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet getAll(){
        String query = "SELECT * FROM client c left join accounts a on c.id=a.client_id";
        return executeQuery(query);
    }
}
