package com.common.deck;

import com.common.card.Card;
import com.common.card.Rank;
import com.common.card.Suit;
import com.common.card.CardImpl;

import java.util.Arrays;

public class Deck {
    public Card[] Cards;
    private Shuffler shuffler;


    @Override
    public String toString() {
        return "DeckImpl{" +
                "Cards=" + Arrays.toString(Cards) +
                '}';
    }

    private Card[] getSortedDeck(/*int cardCount*/) {
        int cardCount=36; // may be 52, 24
        Card[] deck = new Card[cardCount];
        int i = 0;
        for (Suit suit : Suit.values()) {
            if (suit == Suit.HIDDEN) continue;
            for (Rank rank : Rank.values()) {
                if (rank == Rank.HIDDEN) continue;

                if (checkCardDeckConditions(cardCount, 36, rank.ordinal(), 5)) continue;
                if (checkCardDeckConditions(cardCount, 24, rank.ordinal(), 8)) continue;

                deck[i] = new CardImpl(suit, rank);
                i++;
            }
        }
        return deck;
    }

    private boolean checkCardDeckConditions(int cardCount, int exceptionalCardCount, int rankOrdinal, int cardCountControl){
        return isCardCountExceptional(cardCount, exceptionalCardCount) &&
                isOrdinalBigEnough(rankOrdinal, cardCountControl);
    }

    private boolean isCardCountExceptional(int cardCount, int exceptionalCardCount){
        return cardCount == exceptionalCardCount;
    }

    private boolean isOrdinalBigEnough(int cardOrdinal, int cardOrdinalControl){
        return cardOrdinal < cardOrdinalControl;
    }
}
