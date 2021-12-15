package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "딜러";
    }

    public boolean wantMoreCard() {
        return getTotalScore() <= 16;
    }

    public Integer getTotalScore() {
        return cards.stream().map(card -> card.score()).reduce(Integer::sum).orElse(0);
    }
}
