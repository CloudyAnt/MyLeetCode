package cn.itscloudy.mylc;

public class Utils {
    private Utils() {
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        int[] widths = new int[matrix[0].length];
        for (int[] value : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                int d = value[j];
                int w = 1;
                while (d / 10 != 0) {
                    d /= 10;
                    w++;
                }
                widths[j] = Math.max(widths[j], w);
            }
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                System.out.printf("%" + widths[j] + "d ", ints[j]);
            }
            System.out.println();
        }
    }
}
