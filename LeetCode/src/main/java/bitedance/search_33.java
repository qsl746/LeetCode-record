package bitedance;

public class search_33 {
    class Solution {
        public int search(int[] nums, int target) {
            if(nums.length==0)return -1;
            if (nums.length==1)return nums[0]==target?0:-1;

            int l=0,r=nums.length-1;

            while (l<=r){
                int mid=(l+r)/2;
                if (nums[mid]==target) return mid;

                if(nums[l]<=nums[mid]){
                    //左边是单调递增
                    if(nums[l]<=target&&target<nums[mid]){
                        r=mid-1;
                    }else {
                        l=mid+1;
                    }
                }else {
                    //右边是单调递增
                    if (nums[mid]<target&&target<=nums[r]){
                        l=mid+1;
                    }else {
                        r=mid-1;
                    }
                }
            }
            return -1;
        }
    }
}
