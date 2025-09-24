package bitedance;

public class findKthLargest_215 {
    class Solution {
        /**
         * 在排序后的数组中：从右往左数是第 k 个元素（k 从 1 开始），从左往右数是第 n - k 个元素（n 为数组长度）。
         * @param nums
         * @param k
         * @return
         */
        public int findKthLargest(int[] nums, int k) {
            int len=nums.length;
            int target=len-k;
            int left=0,right=len-1;
            while (true){
                int j=partition(nums,left,right);
                if(j==target){
                    return nums[j];
                }
                else if (j>target){
                    right=j-1;
                }else {
                    left=j+1;
                }
            }
        }
        public int partition(int[] nums,int left,int right){
            int mid=(left+right)/2;
            int pivot=nums[mid];
            swap(nums,left,mid);

            int le=left+1,ge=right;
            while (true){
                while(le<=ge&&nums[le]<pivot){
                    le++;
                }
                while (le<=ge&&nums[ge]>pivot){
                    ge--;
                }
                if(le>=ge)break;
                swap(nums,le,ge);
                le++;
                ge--;
            }
            swap(nums,left,ge);
            return ge;
        }

        public void swap(int [] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }

}
