package controller;

import domain.user.Players;
import view.InputView;

public class BlackJackController {
    private Players players;

    public BlackJackController() {
        this.players = new Players();
    }

    public void run() {
        getPlayerName();
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
