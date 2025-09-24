package bitedance;

import common.ListNode;

public class reverseKGroup_25 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {

            /**
             *
             * 待翻转的子链为：start-------end
             * pre 指向start前驱，next指向end的后继
             *
             * pre-start-------end-next
             * 每次翻转后，start在最后面，依次更新pre、start、end和next，保持以上顺序
             *
             */
            ListNode dummy=new ListNode(0);
            dummy.next=head;

            ListNode pre=dummy;
            ListNode end=dummy;

            while(end.next!=null){
                for(int i=0;i<k&&end!=null;i++)end=end.next;
                if (end==null)break;

                ListNode start=pre.next;
                ListNode next=end.next;
                end.next=null;

                pre.next=reverse(start);
                start.next=next;

                pre=start;
                end=pre;
            }

            return dummy.next;
        }
        public ListNode reverse(ListNode head){
            ListNode pre=null;
            ListNode curr=head;
            while (curr!=null){
                ListNode next=curr.next;
                curr.next=pre;
                pre=curr;
                curr=next;
            }
            return pre;
        }
    }
}
