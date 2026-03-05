package cn.itscloudy.mylc.easy;

// LeetCode 42
public class TrapWater {

    public int trap(int[] height) {
        // find the highest point
        int maxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }

        // from left to right, calculate trapped water according to the left highest point
        int waterTrapped = 0;
        int partMax = height[0];
        for (int i = 1; i < maxIndex; i++) {
            int h = height[i];
            if (h < partMax) {
                waterTrapped += (partMax - h);
            } else {
                partMax = h;
            }
        }

        // from right to left, calculate trapped water according to the right highest point
        partMax = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            int h = height[i];
            if (h < partMax) {
                waterTrapped += (partMax - h);
            } else {
                partMax = h;
            }
        }

        return waterTrapped;
    }
}
