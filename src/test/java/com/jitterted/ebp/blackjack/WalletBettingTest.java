package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletBettingTest {

    @Test
    public void walletWith12BalanceBet8ThenBalanceIs4() throws Exception {
        Wallet wallet = new Wallet();
        wallet.addMoney(12);

        wallet.bet(8);

        assertThat(wallet.balance())
                .isEqualTo(12 - 8);
    }

    @Test
    public void walletWith27Bet7AndBet9ThenBalanceIs11() throws Exception {
        Wallet wallet = new Wallet();
        wallet.addMoney(27);

        wallet.bet(7);
        wallet.bet(9);

        assertThat(wallet.balance())
                .isEqualTo(27 - 7 - 9);
    }

}
