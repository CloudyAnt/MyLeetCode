package cn.itscloudy.mylc.medium;

// LC1545                                                                                                                                                                                                                                                                                                                                                   1
public class LC1545FindKthBit {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int len = 1;
        int n1 = n;
        while(n1 > 1) {
            len = len * 2 + 1;
            n1--;
        }

        k--; // change to index
        int middle = len / 2;
        if (k == middle) {
            return '1';
        }

        int n2 = n;
        boolean mutated;
        boolean finalMutated = false;
        while(n2 > 1) {
            mutated = k > middle; // middle of current
            len = (len - 1) / 2; // len of last s
            if (mutated) {
                k = middle + len - k; // len - (k - middle)
                finalMutated = !finalMutated;
            }
            if (n2 > 2) {
                middle = len / 2;
                if (k == middle) {
                    return finalMutated ? '0' : '1';
                }
            }
            n2--;
        }
        return finalMutated ? '1' : '0';
    }
}
