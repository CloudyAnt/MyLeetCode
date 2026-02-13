package cn.itscloudy.mylc.hard;

// LeetCode 42
public class TrapWater3D {

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        int[][] waterHeights = new int[n][m]; // the heights when water was injected

        // init
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                    waterHeights[x][y] = heightMap[x][y];
                } else {
                    waterHeights[x][y] = -1;
                }
            }
        }

        // calculate
        for (int x = 1; x < n - 1; x++) {
            for (int y = 1; y < m - 1; y++) {
                check(heightMap, waterHeights, x, y);
            }
        }

        // summate
        int totalWater = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                totalWater += Math.max(0, waterHeights[x][y] - heightMap[x][y]);
            }
        }
        return totalWater;
    }

    public void check(int[][] heightMap, int[][] waterHeights, int x, int y) {
        int lowestWater = waterHeights[x - 1][y];
        lowestWater = Math.min(lowestWater, waterHeights[x][y - 1]);
        if (waterHeights[x + 1][y] != -1) {
            lowestWater = Math.min(lowestWater, waterHeights[x + 1][y]);
        }
        if (waterHeights[x][y + 1] != -1) {
            lowestWater = Math.min(lowestWater, waterHeights[x][y + 1]);
        }

        int prevWallHeight = waterHeights[x][y];
        int currWallHeight = Math.max(heightMap[x][y], lowestWater);

        if (currWallHeight != prevWallHeight) {
            waterHeights[x][y] = currWallHeight;
            if (x - 1 > 0) {
                check(heightMap, waterHeights, x - 1, y);
            }
            if (x + 1 < heightMap.length - 1 && waterHeights[x + 1][y] >= 0) {
                check(heightMap, waterHeights, x + 1, y);
            }
            if (y - 1 > 0) {
                check(heightMap, waterHeights, x, y - 1);
            }
            if (y + 1 < heightMap[x].length - 1 && waterHeights[x][y + 1] >= 0) {
                check(heightMap, waterHeights, x, y + 1);
            }
        }
    }
}
