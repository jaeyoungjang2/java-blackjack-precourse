package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String requirePlayersName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)");
        return SCANNER.nextLine();
    }

    public static int requireBettingCost(String player) {
        System.out.printf("%s의 베팅 금액은?%n", player);
        return SCANNER.nextInt();
    }
}
