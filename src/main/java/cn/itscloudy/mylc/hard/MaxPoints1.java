package cn.itscloudy.mylc.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

// LeetCode 2503
// Solution: Offline query + Minimal heap
public class MaxPoints1 {

    private static final int[] directions = {-1, 0, 1, 0, -1};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Integer[] queryIndices = IntStream.range(0, queries.length).boxed().toArray(Integer[]::new);
        Arrays.sort(queryIndices, Comparator.comparingInt(qi -> queries[qi]));

        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        var count = 0;
        int[] results = new int[queries.length];
        for (Integer qi : queryIndices) {
            var query = queries[qi];
            while (!pq.isEmpty() && pq.peek()[0] < query) {
                var cell = pq.poll();
                count++;
                int x = cell[1];
                int y = cell[2];
                for (int d = 0; d < 4; d++) {
                    int nx = x + directions[d];
                    int ny = y + directions[d + 1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        pq.offer(new int[]{grid[nx][ny], nx, ny});
                    }
                }
            }
            results[qi] = count;
        }
        return results;
    }
}
