package cn.itscloudy.mylc.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NQueueTest {

    NQueue nQueue = new NQueue();

    @ParameterizedTest
    @EnumSource(Case.class)
    void solveNQueens(Case c) {
        List<List<String>> solutions = nQueue.solveNQueens(c.n);
        assertEquals(c.expectedCount, solutions.size(), "solution count for n=" + c.n);
        for (List<String> solution : solutions) {
            assertValidSolution(solution, c.n);
        }
    }

    private void assertValidSolution(List<String> solution, int n) {
        assertEquals(n, solution.size(), "solution must have n rows");
        int totalQueens = 0;
        int[] queenCols = new int[n];
        for (int row = 0; row < n; row++) {
            String line = solution.get(row);
            assertEquals(n, line.length(), "row " + row + " must have n chars");
            int qInRow = 0;
            for (int col = 0; col < n; col++) {
                char ch = line.charAt(col);
                assertTrue(ch == 'Q' || ch == '.', "only Q or . allowed");
                if (ch == 'Q') {
                    totalQueens++;
                    qInRow++;
                    queenCols[row] = col;
                }
            }
            assertEquals(1, qInRow, "each row must have exactly one Q");
        }
        assertEquals(n, totalQueens, "must have exactly n queens");

        // no two queens on same column
        Set<Integer> cols = new HashSet<>();
        for (int col : queenCols) {
            assertTrue(cols.add(col), "duplicate column");
        }

        // no two on same diagonal: for (r1,c1) and (r2,c2), r1-c1 != r2-c2 and r1+c1 != r2+c2
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d1 = i - queenCols[i];
                int d2 = j - queenCols[j];
                int s1 = i + queenCols[i];
                int s2 = j + queenCols[j];
                assertTrue(d1 != d2, "same anti-diagonal");
                assertTrue(s1 != s2, "same main diagonal");
            }
        }
    }

    enum Case {
        N1(1, 1),
        N2(2, 0),
        N3(3, 0),
        N4(4, 2),
        N5(5, 10),
        N6(6, 4),
        N8(8, 92),
        ;

        private final int n;
        private final int expectedCount;

        Case(int n, int expectedCount) {
            this.n = n;
            this.expectedCount = expectedCount;
        }
    }
}
