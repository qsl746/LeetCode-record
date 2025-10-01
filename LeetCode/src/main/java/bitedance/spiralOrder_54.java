package bitedance;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res=new ArrayList<>();
            if (matrix==null)return res;

            //定义上下左右四个边界
            int top=0,button=matrix.length-1,left=0,right=matrix[0].length-1;

            while (true) {
                //→
                for (int i=left;i<=right;i++){
                    res.add(matrix[top][i]);
                }
                if ((++top)>button)break;//减掉遍历过的行，并判断是否还有数据

                //↓
                for(int i=top;i<=button;i++){
                    res.add(matrix[i][right]);
                }
                if ((--right)<left)break;

                //←
                for (int i = right; i >= left; i--) {
                    res.add(matrix[button][i]);
                }
                if ((--button)<top)break;

                //↑
                for (int i=button;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                if ((++left)>right)break;
            }

            return res;
        }
    }
}
