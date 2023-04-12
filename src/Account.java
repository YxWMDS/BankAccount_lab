public class Account implements Blockable{

    private int money;
    private boolean isBlocked = false;
    private int id;
    private static int counter = 0;

    public Account(int money) {
        this.money = money;
        id = counter++;
    }

    public int getMoney() {
        return money;
    }

    public int getId(){
        return id + 1;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean getStatus(){
        return isBlocked;
    }

    @Override
    public void blockAccount() {
        isBlocked = true;
        System.out.println("Ur account is blocked");
    }

    @Override
    public void unblockAccount() {
        isBlocked = false;
        System.out.println("Congrats! Ur account is unblocked");
    }

    public String toString(){
        return "\nAccount " + getId() + " has " + getMoney() + " BYN.\n" + "status of block: " + isBlocked;
    }
}
