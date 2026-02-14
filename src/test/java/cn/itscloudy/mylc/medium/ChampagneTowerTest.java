package cn.itscloudy.mylc.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChampagneTowerTest {

    ChampagneTower champagneTower = new ChampagneTower();

    @ParameterizedTest
    @EnumSource(Case.class)
    void simulate(Case cass) {
        CaseData data = cass.data;
        double actual = champagneTower.champagneTower(data.poured, data.queryRow, data.queryGlass);

        assertEquals(data.expected, actual);
    }

    enum Case {
        CASE1(new CaseData(0, 0, 0, 0)),
        CASE2(new CaseData(100, 1, 0, 1)),
        CASE3(new CaseData(3, 2, 0, 0)),
        CASE4(new CaseData(4, 2, 0, 0.25)),
        CASE5(new CaseData(5, 2, 0, 0.50)),
        CASE6(new CaseData(8, 3, 1, 0.875)),
        CASE7(new CaseData(1, 1000, 500, 0)),
        ;

        private final CaseData data;

        Case(CaseData data) {
            this.data = data;
        }
    }

    record CaseData(int poured, int queryRow, int queryGlass, double expected) { }
}
