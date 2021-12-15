package controller;

import domain.user.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.InputView;

public class BlackJackController {

    private List<Player> players = new ArrayList<>();

    public void run() {
        String stringPlayer = InputView.requirePlayer();
        List<String> players = Arrays.asList(stringPlayer.split(","));
        for (String player : players) {
            String bettingMoney = InputView.requireBettingMoney(player);
            this.players.add(new Player(player, Integer.parseInt(bettingMoney)));
        }
    }
}
