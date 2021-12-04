package domain.user;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players;

    public Players() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(String player, int bettingCost) {
        players.add(new Player(player, bettingCost));
    }


    public void playFirstTurn(CardMaster cardMaster) {
        players.forEach(player -> saveTwoCard(player, cardMaster));
    }

    private void saveTwoCard(Player player, CardMaster cardMaster) {
        for (int i = 0; i < 2; i++) {
            player.addCard(cardMaster.card());
        }
    }
}
