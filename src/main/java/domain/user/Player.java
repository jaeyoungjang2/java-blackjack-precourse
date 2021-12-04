package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    private String finish = "n";

    public Player(String name, double bettingMoney) {
        validNameLength(name);
        validBettingCost(bettingMoney);
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    private void validBettingCost(double bettingMoney) {
        if (bettingMoney <= 0) {
            throw new IllegalArgumentException("베팅 금액은 0원 보다 커야 합니다.");
        }
    }

    private void validNameLength(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("플레이어의 이름은 1자 이상 5자 이하로 구성되어야 합니다.");
        }

        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("플레이어의 이름은 1자 이상 5자 이하로 구성되어야 합니다.");
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> cards() {
        return cards;
    }

    public String name() {
        return name;
    }

    public String finish() {
        return finish;
    }

    // TODO 추가 기능 구현

}
