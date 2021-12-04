package view;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printFirstRoundPlayerCardState(List<Player> players ) {
        players.stream()
            .map(OutputView::printCardState)
            .forEach(System.out::println);
    }

    private static String printCardState(Player player) {
        List<Card> cards = player.cards();
        String cardState = cards.stream()
            .map(OutputView::transferCardSymbol)
            .collect(Collectors.joining(","));

        return player.name() + ":" + cardState;
    }

    private static String transferCardSymbol(Card card) {
        Integer score = card.score();
        String type = card.symbol();
        return type + score;
    }

    public static void printFirstRoundDealerCardState(Dealer dealer) {
        List<Card> cards = dealer.cards();
        Card firstCard = cards.get(0);
        System.out.println("딜러: " + firstCard.symbol() + firstCard.score());
    }

    public static void printFirstTurnInfo(List<Player> players) {
        String playersName = players.stream()
            .map(OutputView::getPlayersName)
            .collect(Collectors.joining(","));
        System.out.println("딜러와 " + playersName + "에게 2장의 카드를 나누었습니다.");
    }

    private static String getPlayersName(Player player) {
        return player.name();
    }
}
