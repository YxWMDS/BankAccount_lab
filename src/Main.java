import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, WrongWithdrawEx {
        EditDb edb = new EditDb();
        ResultSet rs = GetFromDb.getAll();

        while (rs.next()) {
            System.out.println(rs.getInt("money"));
        }

        edb.addAccount(7777, true, 2);
        //edb.deleteAccount(6);

        Client alexey = new Client("Alexey");
        alexey.makeNewAccount(3000);
        alexey.searchAccountWithId(1);
        alexey.getAccount(1).blockAccount();
        alexey.withdrawMoney(1, 3500);

        alexey.makeNewAccount(1000);
        alexey.putMoney(2,1800);

        alexey.makeNewAccount(-900);
        alexey.makeNewAccount(-1000);

        alexey.showAccounts();

        alexey.getSumOfPositive();
        alexey.getSumOfNegative();
        alexey.getTotalSum();

        alexey.showAccountsSortedByMoney();

    }
}
