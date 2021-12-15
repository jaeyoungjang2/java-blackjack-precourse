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

    public static void printPlayerCardInfo(Player player) {
        List<Card> cards = player.getCards();

        String cardName = cards.stream().map(card -> card.toString())
            .collect(Collectors.joining(","));
        String playerName = player.name();
        System.out.printf("%s카드: %s%n", playerName, cardName);
    }

    public static void printFirstRoundDealerCardInfo(Dealer dealer) {
        List<Card> cards = dealer.getCards();
        Card firstCard = cards.get(0);
        System.out.printf("%s: %s%n", dealer.toString(), firstCard.toString());
    }

    public static void printDealerGetMoreCard() {
        System.out.printf("딜러는 16이하라 한장의 카드를 더 받았습니다.%n");
    }

    public static void printDealerCardInfo(Dealer dealer) {
        List<Card> cards = dealer.getCards();

        String cardName = cards.stream().map(card -> card.toString())
            .collect(Collectors.joining(","));
        System.out.printf("%s카드: %s%n", "딜러", cardName);
    }

    public static void printResultInfo() {
        System.out.println("## 최종수익");
    }

    public static void printDealerEarnMoney(double v) {
        System.out.printf("딜러: v%n");
    }

    public static void printPlayerEarnMoney(double playerEarnMoney, Player player) {
        System.out.printf("%s: %s%n", player.name(), playerEarnMoney);
    }
}
