package cn.itscloudy.mylc.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomaToIntTest {

    RomaToInt romaToInt = new RomaToInt();

    @ParameterizedTest
    @EnumSource(Case.class)
    void test(Case cass) {
        int actual = romaToInt.romanToInt(cass.roma);

        assertEquals(cass.expected, actual);
    }

    enum Case {
        CASE1("MDCLXVI", 1666),
        CASE2("CMXCIX", 999),
        CASE3("MCXI", 1111),
        CASE4("CDXLIV", 444),
        CASE5("DLV", 555),
        CASE6("DCCCLXXXVIII", 888),
        CASE7("DCLXVI", 666),
        CASE8("MMCCXXII", 2222),
        CASE9("MMCCXLIV", 2244),
        CASE10("CMXCVII", 997),
        ;

        private final String roma;
        private final int expected;

        Case(String roma, int expected) {
            this.roma = roma;
            this.expected = expected;
        }
    }
}
