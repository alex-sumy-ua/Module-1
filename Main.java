public class Main {

    public static void main(String[] args) throws InterruptedException {

        Account account = new Account(100); // do synchronize on this object

        Terminal terminal1 = new Terminal(2, account);
        Terminal terminal2 = new Terminal(3, account);
//        Terminal terminal3 = new Terminal(1, account);

        terminal1.start();
        terminal2.start();
//        terminal3.start();

        terminal1.join();
        terminal2.join();
//        terminal3.join();

        System.out.println(account.getTotal());


    }

}
