class Solution {
    public static int trap(int[] height) {
        int n = height.length;
        //calculate leftmax boundary of array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        //calculate rightmax boundary of array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        //waterlevel = min(leftmax[i],rightmax[i])
        int trapingWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            trapingWater += waterLevel - height[i];
        }
        return trapingWater;

        //traping water = waterlevel - heightlevel
    }

    public static void main(String args[]) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };

        System.out.println("trapedRainwater : " + trap(height));
        
    }
}