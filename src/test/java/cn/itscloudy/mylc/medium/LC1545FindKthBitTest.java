package cn.itscloudy.mylc.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC1545FindKthBitTest {

    LC1545FindKthBit solver = new LC1545FindKthBit();

    @ParameterizedTest
    @EnumSource(Case.class)
    void findKthBit(Case cass) {
        CaseData data = cass.data;
        char actual = solver.findKthBit(data.n, data.k);

        assertEquals(data.expected, actual);
    }

    enum Case {
        CASE1(new CaseData(1, 1, '0')),
        CASE2(new CaseData(2, 1, '0')),
        CASE3(new CaseData(2, 2, '1')),
        CASE4(new CaseData(2, 3, '1')),
        CASE5(new CaseData(3, 1, '0')),
        CASE6(new CaseData(3, 4, '1')),
        CASE7(new CaseData(3, 7, '1')),
        CASE8(new CaseData(4, 1, '0')),
        CASE9(new CaseData(4, 8, '1')),
        CASE10(new CaseData(4, 11, '1')),
        CASE11(new CaseData(4, 15, '1')),
        ;

        private final CaseData data;

        Case(CaseData data) {
            this.data = data;
        }
    }

    record CaseData(int n, int k, char expected) { }
}
