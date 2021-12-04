package domain.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SymbolTest {
    @Test
    void test() {
        int score = Symbol.ACE.getScore();
        System.out.println(score);
    }
}