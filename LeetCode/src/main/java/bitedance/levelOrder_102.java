package bitedance;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrder_102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res=new ArrayList<>();
            if (root==null)return res;

            //用列表，两个计数值，一个统计当前层有几个，一个统计下一层
            Queue<TreeNode> queue=new ArrayDeque<>();
            queue.add(root);
            int currentLevel=1;
            while (!queue.isEmpty()){
                List<Integer> temp=new ArrayList<>();
                int nextLevel=0;
                while (currentLevel!=0){
                    TreeNode pollNode = queue.poll();
                    temp.add(pollNode.val);
                    if (pollNode.left!=null){
                        queue.add(pollNode.left);
                        nextLevel++;
                    }
                    if (pollNode.right!=null){
                        queue.add(pollNode.right);
                        nextLevel++;
                    }
                    currentLevel--;
                }
                currentLevel=nextLevel;
                res.add(temp);
            }
            return res;
        }
        public List<List<Integer>> levelOrder_2(TreeNode root) {
            List<List<Integer>> res=new ArrayList<>();
            if (root==null)return res;

            //用列表，两个计数值，一个统计当前层有几个，一个统计下一层
            Queue<TreeNode> queue=new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()){
                List<Integer> temp=new ArrayList<>();
                int count=queue.size();
                while ((count--)>0){
                    TreeNode pollNode = queue.poll();
                    temp.add(pollNode.val);
                    if (pollNode.left!=null){
                        queue.add(pollNode.left);
                    }
                    if (pollNode.right!=null){
                        queue.add(pollNode.right);
                    }
                }
                res.add(temp);
            }
            return res;
        }

    }
}
