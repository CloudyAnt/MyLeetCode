package cn.itscloudy.mylc.easy;

// LeetCode 13
public class RomaToInt {

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        var last = 0;
        var sum = 0;
        for (char c : chars) {
            switch (c) {
                case 'I':
                    last = 1;
                    sum++;
                    break;
                case 'V':
                    sum += 5;
                    if (last == 1) {
                        sum -= 2;
                    }
                    last = 5;
                    break;
                case 'X':
                    sum += 10;
                    if (last == 1) {
                        sum -= 2;
                    }
                    last = 10;
                    break;
                case 'L':
                    sum += 50;
                    if (last == 10) {
                        sum -= 20;
                    }
                    last = 50;
                    break;
                case 'C':
                    sum += 100;
                    if (last == 10) {
                        sum -= 20;
                    }
                    last = 100;
                    break;
                case 'D':
                    sum += 500;
                    if (last == 100) {
                        sum -= 200;
                    }
                    last = 500;
                    break;
                case 'M':
                    sum += 1000;
                    if (last == 100) {
                        sum -= 200;
                    }
                    last = 1000;
                    break;
            }
        }
        return sum;
    }
}
