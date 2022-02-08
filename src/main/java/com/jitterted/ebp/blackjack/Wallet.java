package com.jitterted.ebp.blackjack;

public class Wallet {
    private int balance;

    public Wallet() {
        balance = 0;
    }

    public boolean isEmpty() {
        return balance == 0;
    }

    public void addMoney(int amount) {
        checkAmountNotNegative(amount);
        balance += amount;
    }

    public int balance() {
        return balance;
    }

    private void checkAmountNotNegative(int amount) {
        if (amount <= -1) {
            throw new IllegalArgumentException();
        }
    }
}
