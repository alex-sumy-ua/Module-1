public class Terminal extends Thread {

    /*
    / operation
    / 1 - view, 2 - add, 3 - remove
     */
    private int operation = 0;
    private int nOperations = 10;
    private Account account;

    public Terminal(int operation, Account account) {
        this.operation = operation;
        this.account = account;
    }

    @Override
    public void run() {

        switch (operation) {
            case 1: {
                // view
                for (int i = 0; i < nOperations; i++) {
                    synchronized (account) {
                        System.out.println(getName() + " " + i + "  Total: " + account.getTotal());
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            case 2: {
                // add
                for (int i = 0; i < nOperations; i++) {
                    synchronized (account) {
                        account.addSum(1);
                    }
                    System.out.println(getName() + " " + i + "  Adding successfull. Total: " + account.getTotal());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            case 3: {
                // remove
                for (int i = 0; i < nOperations; i++) {
                    synchronized (account) {
                        if (account.getTotal() > 0) {
                            account.remSum(1);
                            System.out.println(getName() + " " + i + "  Removing successfull. Total: " + account.getTotal());
                        } else {
                            System.out.println(getName() + " " + i + "  Removing impossible, waiting. Total: " + account.getTotal());
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }

}

