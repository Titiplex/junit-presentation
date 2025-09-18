package com.titiplex.advanced;

public class BankAccount {
    private long balance;

    public BankAccount(long initial) {
        this.balance = initial;
    }

    public synchronized void deposit(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount <= 0");
        balance += amount;
    }

    public synchronized void withdraw(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount <= 0");
        if (amount > balance) throw new IllegalStateException("insufficient");
        balance -= amount;
    }

    public long balance() {
        return balance;
    }
}
