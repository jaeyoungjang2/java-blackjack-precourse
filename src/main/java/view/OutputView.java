package view;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printFirstRoundInfo(List<Player> players) {
        String playersName = playersName(players);
        System.out.printf("딜러와 %s에게 2장의 카드를 나누었습니다.%n", playersName);
    }

    private static String playersName(List<Player> players) {
        return players.stream().map(player -> player.name()).collect(Collectors.joining(", "));
    }

    public static void printFirstRoundPlayerCardInfo(Player player) {
        List<Card> cards = player.getCards();
        Card firstCard = cards.get(0);
        Card secondCard = cards.get(1);
        String playerName = player.name();
        System.out.printf("%s카드: %s,%s%n", playerName, firstCard.toString(), secondCard.toString());
    }

    public static void printFirstRoundDealerCardInfo(Dealer dealer) {
        List<Card> cards = dealer.getCards();
        Card firstCard = cards.get(0);
        System.out.printf("%s: %s%n", dealer.toString(), firstCard.toString());
    }
}
