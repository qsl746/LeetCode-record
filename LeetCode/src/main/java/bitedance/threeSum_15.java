package bitedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class threeSum_15 {
    class Solution {
        /**
         * 降维+双指针
         * 1、排序之后，第一个大于零，三数相加必定>0
         * 2、三数相加大于零，则减小right指针，小于零则增大left指针
         * 3、每次必须跳过重复的数
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            int len=nums.length;
            List<List<Integer>> res=new ArrayList<>();
            if(len<3){
                return res;
            }

            Arrays.sort(nums);
            for (int i = 0; i < len; i++) {
                if(nums[i]>0){
                    break;
                }
                if(i>0&&nums[i]==nums[i-1]) continue;
                int left=i+1;
                int right=len-1;
                while (left<right){
                    if(nums[i]+nums[left]+nums[right]==0){
                        res.add(List.of(nums[i],nums[left],nums[right]));
                        while (left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[i]+nums[left]+nums[right]>0){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
            return res;
        }
    }
}
