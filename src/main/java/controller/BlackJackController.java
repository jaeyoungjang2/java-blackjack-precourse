package controller;

import domain.user.Player;
import java.util.Scanner;

public class BlackJackController {

    public void run() {
        getPlayerName();
    }

    private void getPlayerName() {
        try {
            Scanner sc = new Scanner(System.in);
            Player player = new Player(sc.nextLine(), 10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getPlayerName();
        }
    }
}
