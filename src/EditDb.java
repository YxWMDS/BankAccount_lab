import java.sql.SQLException;

public class EditDb extends MySQLConnect{
    String query;
    public void addAccount(int money, boolean isBlocked, int client_id){
        query = "insert into accounts (money, is_blocked, client_id) values (" + money + ", "
                + isBlocked + ", " + client_id + ")";
        start();
    }

    public void deleteAccount(int acId){
        query = "delete from accounts where id=" + acId;
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("executeQuery: " + query);
        executeQuery(query);
    }

    private static void executeQuery(String query) {
        try {
            getConnection()
                    .createStatement()
                    .executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
