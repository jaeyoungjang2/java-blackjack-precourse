package view;

import domain.card.Card;
import domain.user.Player;
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
}
