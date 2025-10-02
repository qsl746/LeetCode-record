package bitedance;

import java.awt.font.FontRenderContext;

public class longestPalindrome_5 {
    class Solution {
        public String longestPalindrome(String s) {

            int len=s.length();
            if (len<2)return s;

            char[] sChar = s.toCharArray();
            boolean[][] dp =new boolean[len] [len];//记录子串下标从i~j是否为回文，是则dp[i][j]为true
            for(int i=0;i<len;i++)dp[i][i]=true;

            int maxLen=1,start=0;
            //先从长度为2开始遍历，直到最大长度len
            for (int L=2;L<=len;L++){
                for (int i=0;i<len;i++){
                    //左边界为i，有边界为j，L=j-i+1
                    int j=i+L-1;
                    if (j>=len)break;

                    if (sChar[i]==sChar[j]){
                        //头尾字符相同，如果长度为2如aa、bb，则为回文，否则依赖去掉头尾的子串是否是回文
                        if (j-i<3)dp[i][j]=true;
                        else {
                            dp[i][j]=dp[i+1][j-1];
                        }
                    }
                    if (dp[i][j]){
                        if (L>maxLen){
                            maxLen=L;
                            start=i;
                        }
                    }
                }


            }

            return s.substring(start,start+maxLen);
        }
    }
}
