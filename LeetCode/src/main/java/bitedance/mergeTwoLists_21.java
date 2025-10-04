package bitedance;

import common.ListNode;

public class mergeTwoLists_21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1==null)return list2;
            else if(list2==null) return list1;
            else if (list1.val>list2.val){
                list2.next= mergeTwoLists(list1,list2.next);
                return list2;//只在第一次调用时返回一次，返回的是合并结果的头结点！！！
            }else{
                list1=mergeTwoLists(list1.next,list2);
                return list1;//只在第一次调用时返回一次，返回的是合并结果的头结点！！！
            }
        }
    }
}
