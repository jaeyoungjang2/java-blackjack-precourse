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
        }).hasMessageContaining("플레이어의 이름은 5자 이하로 구성되어야 합니다.");
    }
}