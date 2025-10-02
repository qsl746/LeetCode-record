package bitedance;

import common.ListNode;

public class getIntersectionNode_160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA==null||headB==null)return null;
            ListNode AA=headA,BB=headB;
            //AA遍历完headA再遍历headB，BB类似。
            //如果有相交，则相遇时AA=BB；如果没有相交，则AA=BB都在尾端NULL
            while (AA!=BB){
                AA=AA==null?headB:AA.next;
                BB=BB==null?headA:BB.next;
            }
            return AA;
        }
    }
}
