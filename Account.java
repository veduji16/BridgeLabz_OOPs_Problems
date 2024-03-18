package OOPs_Practice_Problems;

public class Account {

    private double balance;

    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Debit successful. Remaining balance: " + this.balance);
        } else {
            System.out.println("Debit amount exceeded account balance. Balance remains unchanged.");
        }
    }
}

class AccountTest {
    private final Account account;

    public AccountTest() {
        this.account = new Account(1000);
    }

    public void testDebit() {
        System.out.println("Testing debit method: ");
        System.out.println("Initial balance: " + this.account.getBalance() + "\n");

        System.out.println("Requested amount to debit: 500");
        this.account.debit(500);
        System.out.println("Current Balance " + this.account.getBalance() + "\n");

        System.out.println("Requested amount to debit: 600");
        this.account.debit(600);
        System.out.println("Current Balance " + this.account.getBalance() + "\n");
    }

    public static void main(String[] args) {
        AccountTest test = new AccountTest();
        test.testDebit();
    }
}
