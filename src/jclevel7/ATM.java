package jclevel7;


/*Figure out how the program works.

During testing, the log was found to contain the following:
.....
Deposit 100, account balance 1100
Deposit 100, account balance 1200
Spend 1000, account balance 100
Insufficient money
.....

There's a bug:
Money is lost when debiting an account.

Find and fix the bug.

Requirements:
•	The BankAccount class must contain a private BigDecimal field called balance.
•	The BankAccount class's deposit(String money) method must delegate behavior to the deposit(BigDecimal money) method.
•	The BankAccount class's withdraw(String money) method must delegate behavior to the withdraw(BigDecimal money) method.
•	Use synchronized in the withdraw(BigDecimal money) method, if necessary.
•	Use synchronized in the deposit(BigDecimal money) method, if necessary.*/

public class ATM {

    static BankAccount account = new BankAccount("Amigo");

    public static volatile boolean isStopped;

    public static void main(String[] args) throws InterruptedException {
        addMoney.start();
        SpendThread spendThread = new SpendThread();
        SpendThread spendThread1 = new SpendThread();
        SpendThread spendThread2 = new SpendThread();
        spendThread.start();
        spendThread1.start();
        spendThread2.start();
        Thread.sleep(4000);
        isStopped = true;
    }

    private static Thread addMoney = new Thread() {
        @Override
        public void run() {
            while (!isStopped) {
                account.deposit("1000");            // Make a deposit
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };

    public static class SpendThread extends Thread {

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    account.withdraw("100");             // Make a withdrawal
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Insufficient money");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
