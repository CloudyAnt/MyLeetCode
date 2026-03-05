package cn.itscloudy.mylc.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrapWater3D {
    private static final int[] directions = {-1, 0, 1, 0, -1};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int result = 0 ;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + directions[d];
                int ny = curr[1] + directions[d + 1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                    result += Math.max(0, curr[2] - heightMap[nx][ny]);
                    pq.offer(new int[]{nx, ny, Math.max(curr[2], heightMap[nx][ny])});
                    visited[nx][ny] = true;
                }
            }
        }
        return result;
    }
}
