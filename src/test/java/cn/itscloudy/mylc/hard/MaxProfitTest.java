package cn.itscloudy.mylc.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitTest {

    private final MaxProfit maxProfit = new MaxProfit();

    @ParameterizedTest
    @EnumSource(Case.class)
    void test(Case cass) {
        int result = maxProfit.maxProfit(cass.prices);
        assertEquals(cass.expected, result);
    }

    enum Case {
        CASE1(new int[]{1, 2, 3, 4, 5}, 4),
        CASE2(new int[]{5, 4, 3, 2, 1}, 0),
        CASE3(new int[]{1, 10, 1, 11, 1, 2}, 19),
        CASE4(new int[]{1, 10, 11, 10, 11, 20, 1, 2}, 20),
        ;
        private final int[] prices;
        private final int expected;

        Case(int[] prices, int expected) {
            this.prices = prices;
            this.expected = expected;
        }
    }
}
