package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    static Hand createForTest(List<Card> cards) {
        return new Hand(cards);
    }

    private Hand(List<Card> cards) {
        this.cards = cards;
    }

    void drawCardFrom(Deck deck) {
        cards.add(deck.draw());
    }

    int value() {
        int handValue = cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }

    // TODO: Is this specific to Dealer Hand?
    Card faceUpCard() {
        return cards.get(0);
    }

    void display() {
        System.out.println(cards.stream()
                                .map(Card::display)
                                .collect(Collectors.joining(
                                       ansi().cursorUp(6).cursorRight(1).toString())));
    }

    boolean isBusted() {
        return value() > 21;
    }

    // TODO: Is this specific to Dealer Hand?
    boolean shouldDealerHit() {
        return value() <= 16;
    }

    boolean pushes(Hand hand) {
        // guard clause: require not busted
        return value() == hand.value();
    }

    boolean beats(Hand hand) {
        // guard clause: require not busted
        return value() > hand.value();
    }
}
