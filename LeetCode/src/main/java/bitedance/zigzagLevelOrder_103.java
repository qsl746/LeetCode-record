package bitedance;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class zigzagLevelOrder_103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res=new ArrayList<>();
            if (root==null)return res;

            List<TreeNode> layer =new ArrayList<>();
            layer.add(root);
            boolean isReverse=false;//判断是否需要翻转，每下一层就翻转一次
            while (!layer.isEmpty()){
                List<Integer> temp=new ArrayList<>();
                List<TreeNode> nextLayer =new ArrayList<>();

                for (int i=0;i<layer.size();i++){
                    if(isReverse){
                        //需要翻转就逆序取值
                        temp.add(layer.get(layer.size()-i-1).val);
                    }else{
                        temp.add(layer.get(i).val);
                    }

                    //只获取非null子节点
                    if (layer.get(i).left!=null)
                        nextLayer.add(layer.get(i).left);
                    if (layer.get(i).right!=null)
                        nextLayer.add(layer.get(i).right);
                }
                isReverse=!isReverse;
                layer=nextLayer;
                res.add(temp);
            }
            return res;
        }
    }
}
