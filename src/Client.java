import java.util.ArrayList;

public class Client extends Person {

    private ArrayList<Account> accounts = new ArrayList<>(1);

    @Override
    public String getName() {
        return super.getName();
    }

    public Client(String name) {
        super(name);
    }

    public void showAccounts(){
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    //Exception index out of bounds exception
    public void searchAccountWithId(int accountid){
        try {
            System.out.println(accounts.get(accountid - 1));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    public Account getAccount(int accountId){
        if(accountId > 0) {
            return accounts.get(accountId - 1);
        }else{
            System.out.println("Account with id " + accountId + " doesn't exist. Try again");
            return null;
        }
    }

    public void makeNewAccount(int money){
        accounts.add(new Account(money));
    }

    public void putMoney(int accountId, int sum){
        if(!accounts.get(accountId - 1).getStatus()) {
            accounts.get(accountId - 1).setMoney(accounts.get(accountId - 1).getMoney() + sum);
        }else{
            System.out.println("U can't put money on this account. Status of block: " + accounts.get(accountId).getStatus());
        }
    }

    public void withdrawMoney(int accountId, int sum) throws WrongWithdrawEx{
        if(accounts.get(accountId - 1).getMoney() < sum){
            throw new WrongWithdrawEx();
        }
        if(!accounts.get(accountId - 1).getStatus()) {
            accounts.get(accountId - 1).setMoney(accounts.get(accountId - 1).getMoney() - sum);
        }else{
            System.out.println("U can't withdraw money on this account. Status of block: " + accounts.get(accountId - 1).getStatus());
        }
    }

    public void getTotalSum(){
        int res = 0;

        for(Account account: accounts){
            res += account.getMoney();
        }

        System.out.println("Total sum of money of all ur accounts is: " + res);
    }

    public void getSumOfNegative(){
        int res = 0;

        for(Account account: accounts){
            if(account.getMoney() <= 0)
                res += account.getMoney();
        }

        System.out.println("Sum of negative accounts: " + res);
    }

    public void getSumOfPositive(){
        int res = 0;

        for(Account account: accounts){
            if(account.getMoney() >= 0)
                res += account.getMoney();
        }

        System.out.println("Sum of positive accounts: " + res);
    }

    public void showAccountsSortedByMoney(){
        Account[] accsToSort = new Account[accounts.size()];
        for(int i = 0; i < accounts.size(); i++){
            accsToSort[i] = accounts.get(i);
        }

        boolean isSorted = false;
        Account tmp;

        while (!isSorted){
            isSorted = true;
            for(int i = 0; i < accsToSort.length - 1; i++){
                if(accsToSort[i].getMoney() > accsToSort[i+1].getMoney()){
                    isSorted = false;

                    tmp = accsToSort[i];
                    accsToSort[i] = accsToSort[i+1];
                    accsToSort[i+1] = tmp;
                }
            }
        }
        System.out.println("\n------------------Accounts-sorted-by-money------------------");
        for(int i = 0; i < accsToSort.length;i++){
            System.out.println(i+1 + " account:" + accsToSort[i]);
        }
    }
}
