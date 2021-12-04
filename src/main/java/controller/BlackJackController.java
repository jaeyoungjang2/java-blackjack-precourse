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
        String playersName = InputView.requirePlayersName();

    }
}
