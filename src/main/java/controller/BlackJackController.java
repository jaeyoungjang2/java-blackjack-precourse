package controller;

import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Dealer;
import domain.user.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import view.InputView;
import view.OutputView;

public class BlackJackController {

    private List<Player> players = new ArrayList<>();
    private Dealer dealer = new Dealer();

    public void run() {
        prepareBlackJack();
        playFirstRound();
    }

    private void playFirstRound() {
        List<Card> cards = shuffledCard();
        int index = 0;

        OutputView.printFirstRoundInfo(players);

        Card card = cards.get(index);
        index ++;
        dealer.addCard(card);
        card = cards.get(index);
        index ++;
        dealer.addCard(card);
        OutputView.printFirstRoundDealerCardInfo(dealer);

        for (Player player : players) {
            card = cards.get(index);
            index ++;
            player.addCard(card);
            card = cards.get(index);
            index ++;
            player.addCard(card);

            OutputView.printFirstRoundPlayerCardInfo(player);
        }

    }

    private List<Card> shuffledCard() {
        List<Card> testCards = CardFactory.create();
        List<Card> newCards = new ArrayList<>();
        for (Card card : testCards) {
            newCards.add(card);
        }

        Collections.shuffle(newCards);
        return newCards;
    }

    private void prepareBlackJack() {
        String stringPlayer = InputView.requirePlayer();
        List<String> players = Arrays.asList(stringPlayer.split(","));
        for (String player : players) {
            String bettingMoney = InputView.requireBettingMoney(player);
            this.players.add(new Player(player, Integer.parseInt(bettingMoney)));
        }
    }
}
