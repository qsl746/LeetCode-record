package bitedance;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    //滑动窗口问题模板：

    /**
     * //外层循环扩展右边界，内层循环扩展左边界
     * for (int l = 0, r = 0 ; r < n ; r++) {
     * 	//当前考虑的元素
     * 	while (l <= r && check()) {//区间[left,right]不符合题意
     *         //扩展左边界
     *     }
     *     //区间[left,right]符合题意，统计相关信息
     * }
     */

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int res=0;
            char[] ss = s.toCharArray();
            Set<Character> set=new HashSet<>();
            for (int left=0,right=0;right<s.length();right++){
                while(set.contains(ss[right])){
                    set.remove(ss[left]);
                    ++left;
                }
                set.add(ss[right]);
                res=Math.max(res,right-left+1);
            }
            return res;
        }
    }
}
