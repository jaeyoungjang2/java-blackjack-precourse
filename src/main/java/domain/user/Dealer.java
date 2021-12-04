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

    public void playFirstTurn(CardMaster cardMaster) {
        addCard(cardMaster.card());
    }

    public List<Card> cards() {
        return cards;
    }

    public boolean finish() {
        int totalScore = 0;
        for (Card card : cards) {
            totalScore += card.score();
        }

        if (totalScore > 16) {
            return true;
        }
        return false;
    }
    // TODO 추가 기능 구현
}
