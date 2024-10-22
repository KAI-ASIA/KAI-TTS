package Bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private int balance;
    private Lock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    // Rút tiền từ tài khoản
    public boolean withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    // Gửi tiền vào tài khoản
    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}

class Bank {
    private Account[] accounts;

    public Bank(int numAccounts, int initialBalance) {
        accounts = new Account[numAccounts];
        for (int i = 0; i < numAccounts; i++) {
            accounts[i] = new Account(initialBalance);
        }
    }

    // Chuyển tiền giữa các tài khoản
    public void transfer(int from, int to, int amount) {
        if (accounts[from].withdraw(amount)) {
            accounts[to].deposit(amount);
            System.out.println("Transfer " + amount + " from Account " + from + " to Account " + to);
        } else {
            System.out.println("Insufficient balance in Account " + from);
        }
    }

    public int getTotalBalance() {
        int total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        final int NUM_ACCOUNTS = 10;
        final int INITIAL_BALANCE = 1000;
        final int NUM_THREADS = 5;
        final int MAX_AMOUNT = 100;

        Bank bank = new Bank(NUM_ACCOUNTS, INITIAL_BALANCE);

        // Khởi tạo các thread
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    int fromAccount = (int) (Math.random() * NUM_ACCOUNTS);
                    int toAccount = (int) (Math.random() * NUM_ACCOUNTS);
                    int amount = (int) (Math.random() * MAX_AMOUNT);
                    bank.transfer(fromAccount, toAccount, amount);
                }
            });
            t.start();
        }
    }
}
