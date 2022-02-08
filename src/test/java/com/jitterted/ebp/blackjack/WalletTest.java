package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

    @Test
    public void newWalletIsEmpty() throws Exception {
        // Given a Wallet, When it's NEW
        Wallet wallet = new Wallet();

        // Then we expect it to be Empty
        assertThat(wallet.isEmpty())
                .isTrue();
    }

    @Test
    public void newWalletAddMoneyIsNotEmpty() throws Exception {
        // Given a new wallet
        Wallet wallet = new Wallet();

        // When we add money
        wallet.addMoney(1);

        // Then we expect it to NOT be Empty
        assertThat(wallet.isEmpty())
                .isFalse();
    }

    @Test
    public void newWalletHasZeroBalance() throws Exception {
        Wallet wallet = new Wallet();

        assertThat(wallet.balance())
                .isZero();
    }

    @Test
    public void newWalletAdd10ThenBalanceIs10() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(10);

        assertThat(wallet.balance())
                .isEqualTo(10);
    }

    @Test
    public void newWalletAdd7AndAdd8ThenBalanceIs15() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(7);
        wallet.addMoney(8);

        assertThat(wallet.balance())
                .isEqualTo(7 + 8);
    }

    @Test
    public void addNegativeMoneyThrowsException() throws Exception {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}

