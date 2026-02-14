package cn.itscloudy.mylc.medium;

// LeetCode 799
// Solution: Simulate
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] currentRow = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] newRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                newRow[j] += Math.max(0, (currentRow[j] - 1) / 2);
                newRow[j + 1] += Math.max(0, (currentRow[j] - 1) / 2);
            }
            if (newRow[newRow.length / 2] == 0) {
                return 0; // The middle glass is empty, then the whole row and all below must be empty
            }
            currentRow = newRow;
        }
        return Math.min(1, currentRow[query_glass]);
    }
}
