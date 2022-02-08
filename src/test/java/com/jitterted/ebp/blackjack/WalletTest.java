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

}
