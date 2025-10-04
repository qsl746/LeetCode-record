package bitedance;

import java.util.Random;

public class sortArray_912 {
    class Solution {
        public static final Random rand=new Random();
        public int[] sortArray(int[] nums) {
            quickSort(nums,0,nums.length-1);
            return nums;
        }

        void quickSort(int[] nums, int left, int right){
            if (left>=right)return;
            int pivotIndex=partition(nums,left,right);
            quickSort(nums,left,pivotIndex-1);
            quickSort(nums,pivotIndex+1,right);
        }

        int partition(int [] nums,int left,int right){
            int randomIndex=left+rand.nextInt(right-left+1);
            swap(nums,left,randomIndex);

            int pivot=nums[left];
            int le=left+1;
            int ge=right;

            while (true){
                while (le<=ge&&nums[le]<pivot){
                    le++;
                }
                while (le<=ge&&pivot<nums[ge]){
                    ge--;
                }
                if (le>=ge){
                    break;
                }
                swap(nums,le,ge);
                le++;
                ge--;
            }
            //最后退出循环时，可能是pivot....ge le.....，因此应交换nums[ge]并返回ge,才能满足左边都小于pivot
            swap(nums,left,ge);
            return ge;
        }

        void swap(int [] nums,int a,int b){
            int t=nums[a];
            nums[a]=nums[b];
            nums[b]=t;
        }
    }
}
