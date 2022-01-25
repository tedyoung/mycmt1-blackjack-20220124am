package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit DUMMY_SUIT = Suit.SPADES;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Game game = new Game();
        List<Card> cards = createCardListOf("A", "5");

        assertThat(game.handValueOf(cards))
                .isEqualTo(11 + 5); // EVIDENT DATA
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Game game = new Game();
        List<Card> cards = createCardListOf("A", "8", "3");

        assertThat(game.handValueOf(cards))
                .isEqualTo(1 + 8 + 3);
    }

    private List<Card> createCardListOf(String... ranks) {
        return Arrays.stream(ranks)
                     .map(rank -> new Card(DUMMY_SUIT, rank))
                     .collect(Collectors.toList());
    }

}
