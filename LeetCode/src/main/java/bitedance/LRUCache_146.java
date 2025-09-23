package bitedance;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    class LRUCache {

        private Map<Integer,DLinkedNode> cache=new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head,tail;

        public LRUCache(int capacity) {
            this.size=0;
            this.capacity=capacity;
            //使用伪头结点和尾节点，添加和删除节点时可以避免检查是否有相邻节点
            head=new DLinkedNode();
            tail=new DLinkedNode();
            head.next=tail;
            tail.pre=head;
        }

        public int get(int key) {
            //先通过哈希表寻找
            DLinkedNode node = cache.get(key);
            if(node==null){
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if(node==null) {
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    --size;
                }
            }else{
                node.value=value;
                moveToHead(node);
            }
        }
        class DLinkedNode{
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode next;
            public DLinkedNode(){}
            public DLinkedNode(int _key,int _value){
                key=_key;
                value=_value;
            }
        }
        private void addToHead(DLinkedNode node){
            node.pre=head;
            node.next=head.next;
            head.next.pre=node;
            head.next=node;
        }
        private void removeNode(DLinkedNode node){
            node.next.pre=node.pre;
            node.pre.next=node.next;
        }
        private void moveToHead(DLinkedNode node){
            removeNode(node);
            addToHead(node);
        }
        private DLinkedNode removeTail(){
            DLinkedNode res = tail.pre;
            removeNode(res);
            return res;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
