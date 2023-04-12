public class WrongWithdrawEx extends Exception{

    public WrongWithdrawEx(String message) {
        super(message);
    }

    public WrongWithdrawEx() {
        System.out.println("Такой суммы денег нет на счете");
    }
}
