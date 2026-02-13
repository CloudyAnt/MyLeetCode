package cn.itscloudy.mylc.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrapWater3DTest {

    private final TrapWater3D trapWater = new TrapWater3D();

    @ParameterizedTest
    @EnumSource(Case.class)
    void test(Case cass) {
        int result = trapWater.trapRainWater(cass.heightMap);
        assertEquals(cass.expected, result);
    }

    enum Case {
        CASE1(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}},
                4),
        CASE2(new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}},
                10),
        CASE3(new int[][]{{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}},
                14),
        CASE4(new int[][]{{13, 16, 15, 18, 15, 15}, {14, 1, 8, 9, 7, 9}, {19, 5, 4, 2, 5, 10}, {13, 1, 7, 9, 10, 3},
                {17, 7, 5, 10, 6, 1}, {15, 9, 8, 2, 8, 3}},
                36),
        CASE5(new int[][]{{12090, 17684, 13376, 15542, 15936, 19107, 17445, 19756, 19179, 18418}, {
                16887, 9412, 3348, 2172, 1659, 2009, 2336, 5210, 6342, 7587}, {
                18206, 9301, 7713, 7372, 5321, 1255, 4819, 4599, 7721, 9904}, {
                15939, 9811, 3940, 5667, 1705, 6228, 1127, 9150, 5984, 6658}, {
                13920, 9224, 2422, 7269, 1396, 4081, 5630, 84, 9292, 1972}, {
                17672, 3850, 7625, 5385, 1222, 9299, 6640, 6042, 3898, 713}, {
                12298, 6190, 524, 2590, 8209, 8581, 8819, 9336, 7732, 1155}, {
                15994, 8004, 379, 4769, 5273, 1776, 8850, 7255, 1860, 8142}, {
                15579, 5884, 1993, 3205, 7621, 9567, 2504, 613, 1961, 2754}, {
                11326, 4259, 8944, 8202, 3202, 3506, 6784, 2021, 2842, 868}},
                89383),
        ;
        private final int[][] heightMap;
        private final int expected;

        Case(int[][] heightMap, int expected) {
            this.heightMap = heightMap;
            this.expected = expected;
        }
    }
}
