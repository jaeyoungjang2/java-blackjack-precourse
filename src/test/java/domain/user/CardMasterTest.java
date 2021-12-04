package domain.user;

import static org.junit.jupiter.api.Assertions.*;

import domain.card.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardMasterTest {
    @DisplayName("카드 마스터가 뽑은 2개의 카드는 서로 다른 것이다.")
    @Test
    void compareEachCardTest() {
        CardMaster cardMaster = new CardMaster();
        Card firstCard = cardMaster.card();
        Card secondCard = cardMaster.card();
        System.out.println(firstCard.toString());
        System.out.println(secondCard.toString());
    }
}