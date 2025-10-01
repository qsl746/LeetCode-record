package bitedance;

public class trap_42 {
    class Solution {
        public int trap(int[] height) {
            //动态规划，记录每个格子左边最大的和右边最大的，根据木桶效应求解
            int [] leftMaxArray=new int[height.length];
            int [] rightMaxArray=new int[height.length];

            if (height.length<=2)return 0;

            leftMaxArray[0]=height[0];
            rightMaxArray[height.length-1]=height[height.length-1];

            for (int i=1;i<height.length-1;i++){
                leftMaxArray[i]=Math.max(leftMaxArray[i-1],height[i]);
            }
            for (int i=height.length-2;i>=1;i--){
                rightMaxArray[i]=Math.max(rightMaxArray[i+1],height[i]);
            }

            int res=0;
            for (int i=1;i<height.length-1;i++){
                if (height[i]<leftMaxArray[i]&&height[i]<rightMaxArray[i]){
                    res+=Math.min(leftMaxArray[i],rightMaxArray[i])-height[i];
                }
            }


            return res;
        }
    }
}
