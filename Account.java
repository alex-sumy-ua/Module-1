public class Account {

    private int total = 0;

    public Account(int total) {
        this.total = total;
    }

    public int getTotal() {
        return this.total;
    }

    public void addSum(int a) {
        this.total += a;
    }

    public void remSum(int a) {
            this.total -= a;
    }
}
