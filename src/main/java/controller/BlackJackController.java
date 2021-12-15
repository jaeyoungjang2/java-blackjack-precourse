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
    private int cardIndex = 0;
    private List<Card> cards = shuffledCard();

    public void run() {
        prepareBlackJack();
        playFirstRound();
        playAdditionalRound();
        printResult();
    }

    private void printResult() {
        double totalEarnMoney = 0;
        OutputView.printResultInfo();
        for (Player player : players) {
            double playerEarnMoney = player.earnMoney(dealer.getTotalScore());
            totalEarnMoney += playerEarnMoney;
        }
        OutputView.printDealerEarnMoney(-totalEarnMoney);

        for (Player player : players) {
            double playerEarnMoney = player.earnMoney(dealer.getTotalScore());
            OutputView.printPlayerEarnMoney(playerEarnMoney, player);
        }
    }

    private void playAdditionalRound() {
        for (Player player: players) {
            while (true) {
                String wantMoreCard = InputView.addtionalRoundPlayerAddCard(player);
                if (wantMoreCard.equals("y")) {
                    Card card = getShuffledCard(cards);
                    player.addCard(card);
                    OutputView.printPlayerCardInfo(player);
                }
                if (wantMoreCard.equals("n")) {
                    break;
                }
            }
        }

        while (dealer.wantMoreCard()) {
            OutputView.printDealerGetMoreCard();
            Card card = getShuffledCard(cards);
            dealer.addCard(card);
        }

        OutputView.printDealerCardInfo(dealer);
        for (Player player : players) {
            OutputView.printPlayerCardInfo(player);
        }
    }

    private void playFirstRound() {
        OutputView.printFirstRoundInfo(players);

        Card card = getShuffledCard(cards);
        dealer.addCard(card);
        card = getShuffledCard(cards);
        dealer.addCard(card);
        OutputView.printFirstRoundDealerCardInfo(dealer);

        for (Player player : players) {
            card = getShuffledCard(cards);
            player.addCard(card);
            card = getShuffledCard(cards);
            player.addCard(card);

            OutputView.printPlayerCardInfo(player);
        }
    }

    private Card getShuffledCard(List<Card> cards) {
        Card card = cards.get(cardIndex);
        cardIndex ++;
        return card;
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
