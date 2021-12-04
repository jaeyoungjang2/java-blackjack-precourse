package controller;

import domain.user.CardMaster;
import domain.user.Dealer;
import domain.user.Players;
import view.InputView;
import view.OutputView;

public class BlackJackController {
    private Players players;
    private Dealer dealer = new Dealer();
    private CardMaster cardMaster = new CardMaster();

    public BlackJackController() {
        this.players = new Players();
    }

    public void run() {
        getPlayerName();
        playFirstRound();
        printFirstRoundResult();
    }

    private void printFirstRoundResult() {
        OutputView.printFirstRoundPlayerCardState(players.players());

    }

    private void playFirstRound() {
        playFirstTurn(players, dealer);
    }

    private void playFirstTurn(Players players, Dealer dealer) {
        players.playFirstTurn(cardMaster);
        dealer.playFirstTurn(cardMaster);
    }

    private void getPlayerName() {
        String playersStringName = InputView.requirePlayersName();
        String[] playersName = playersStringName.split(",");
        for (String playerName : playersName) {
            int bettingCost = InputView.requireBettingCost(playerName);
            this.players.addPlayer(playerName, bettingCost);
        }
    }
}
