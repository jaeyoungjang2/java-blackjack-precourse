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
        validNameLength(name);
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    private void validNameLength(String name) {
        if (name.length() >= 6) {
            throw new IllegalArgumentException("플레이어의 이름은 1자 이상 5자 이하로 구성되어야 합니다.");
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현

}
