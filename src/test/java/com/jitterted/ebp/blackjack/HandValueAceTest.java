package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit DUMMY_SUIT = Suit.SPADES;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        List<Card> cards = createCardListOf("A", "5");
        Hand hand = Hand.createForTest(cards);

        assertThat(hand.value())
                .isEqualTo(11 + 5); // EVIDENT DATA
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        List<Card> cards = createCardListOf("A", "8", "3");
        Hand hand = Hand.createForTest(cards);

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 3);
    }

    @Test
    public void handWithOneAceAndOneTenValueCardIsValuedAt21() throws Exception {
        List<Card> cards = createCardListOf("A", "J");
        Hand hand = Hand.createForTest(cards);

        assertThat(hand.value())
                .isEqualTo(11 + 10);
    }

    @Test
    public void handWithOneAceAndOtherCardsValuedAs12IsValuedAt13() throws Exception {
        List<Card> cards = createCardListOf("A", "7", "5");
        Hand hand = Hand.createForTest(cards);

        assertThat(hand.value())
                .isEqualTo(1 + 7 + 5);
    }

    private List<Card> createCardListOf(String... ranks) {
        return Arrays.stream(ranks)
                     .map(rank -> new Card(DUMMY_SUIT, rank))
                     .collect(Collectors.toList());
    }

}
