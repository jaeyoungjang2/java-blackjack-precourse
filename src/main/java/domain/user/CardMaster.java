package domain.user;

import domain.card.Card;
import domain.card.CardFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardMaster {
    private List<Card> cards;
    private int nextCardIndex = 0;

    public CardMaster() {
        prepareCards();
    }

    private void prepareCards() {
        this.cards = new ArrayList<>();
        this.cards.addAll(CardFactory.create());
        Collections.shuffle(this.cards);
    }

    public Card card() {
        Card card = this.cards.get(nextCardIndex);
        nextCardIndex ++;
        return card;
    }

}
