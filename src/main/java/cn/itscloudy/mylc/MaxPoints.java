package cn.itscloudy.mylc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

// LeetCode 2503
public class MaxPoints {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int totalCells = m * n;
        int[] size = new int[totalCells];
        int[] parent = new int[totalCells];
        int[][] cells = new int[totalCells][3];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int idx = x * n + y;
                size[idx] = 1;
                parent[idx] = idx;
                cells[idx][0] = grid[x][y];
                cells[idx][1] = x;
                cells[idx][2] = y;
            }
        }
        Arrays.sort(cells, Comparator.comparingInt(c -> c[0]));

        Integer[] queryIndices = IntStream.range(0, queries.length).boxed().toArray(Integer[]::new);
        Arrays.sort(queryIndices, Comparator.comparingInt(qi -> queries[qi]));

        int[] results = new int[queries.length];
        int cellIdx = 0;
        for (int i = 0; i < queryIndices.length; i++) {
            int queryIndex = queryIndices[i];
            int query = queries[queryIndex];
            if (i > 0 && query == queries[queryIndices[i - 1]]) {
                results[queryIndex] = results[queryIndices[i - 1]];
                continue;
            }
            for (; cellIdx < totalCells && cells[cellIdx][0] < query; cellIdx++) {
                int[] cell = cells[cellIdx];
                int x = cell[1];
                int y = cell[2];
                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        if (grid[nx][ny] < query) {
                            merge(parent, size, x * n + y, nx * n + ny);
                        }
                    }
                }
            }

            if (grid[0][0] < query) {
                results[queryIndex] = size[find(parent, 0)];
            }
        }
        return results;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // redirect all nodes in path to the root
        }
        return parent[x];
    }

    private void merge(int[] parent, int[] size, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a != b) {
            // merge small tree to big tree
            if (size[a] < size[b]) {
                parent[a] = b;
                size[b] += size[a];
            } else {
                parent[b] = a;
                size[a] += size[b];
            }
        }
    }
}
