package cn.itscloudy.mylc.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrapWaterTest {

    TrapWater trapWater = new TrapWater();

    @ParameterizedTest
    @EnumSource(Case.class)
    void test(Case cass) {
        int actual = trapWater.trap(cass.heights);

        assertEquals(cass.expected, actual);
    }

    enum Case {
        CASE1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
        CASE2(new int[]{4, 2, 0, 3, 2, 5}, 9),
        ;

        private final int[] heights;
        private final int expected;

        Case(int[] heights, int expected) {
            this.heights = heights;
            this.expected = expected;
        }
    }
}
