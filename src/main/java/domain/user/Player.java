package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String name() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Integer totalScore() {
        return cards.stream().map(card -> card.score()).reduce(Integer::sum).orElse(0);
    }

    // TODO 추가 기능 구현
    public double earnMoney(Integer dealerScore) {
        if (dealerScore > 21) {
            return bettingMoney;
        }
        if (totalScore() > 21) {
            return -bettingMoney;
        }
        if (totalScore() == dealerScore) {
            return 0;
        }
        if (totalScore() == 21 && dealerScore != 21) {
            return bettingMoney * 1.5;
        }
        if (totalScore() > dealerScore) {
            return bettingMoney;
        }
        return - bettingMoney;

    }
}
