package domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @DisplayName("플레이어 이름이 5자 초과인 경우, 예외 사항 확인")
    @Test
    void playerNameLengthTest() {
        Assertions.assertThatThrownBy(() -> {
            new Player("123456", 10000);
        }).hasMessageContaining("플레이어의 이름은 1자 이상 5자 이하로 구성되어야 합니다.");
    }

    @DisplayName("플레이어 이름이 비어 있는 경우, 예외 사항 확인")
    @Test
    void emptyPlayerNameTest() {
        Assertions.assertThatThrownBy(() -> {
            new Player("", 10000);
        }).hasMessageContaining("플레이어의 이름은 1자 이상 5자 이하로 구성되어야 합니다.");
    }

    @DisplayName("베팅금액이 0원 이하일 경우, 예외 사항 확인")
    @Test
    void bettingCostTest() {
        Assertions.assertThatThrownBy(() -> {
            new Player("123", 0);
        }).hasMessageContaining("베팅 금액은 0원 보다 커야 합니다.");
    }
}
