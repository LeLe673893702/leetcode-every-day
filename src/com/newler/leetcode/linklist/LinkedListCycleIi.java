package com.newler.leetcode.linklist;
// [142]、环形链表 II
// 2020年4月2日09:22:17
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针


import com.newler.leetcode.data.ListNode;

public class LinkedListCycleIi {
    public static void main(String[] args) {
        int nums[] = {1,2};
        ListNode listNode = new ListNode(nums);
        listNode.next.next = listNode;
        Solution solution = new Solution();
        solution.detectCycle(listNode);
    }
    /**
     * fast走2步 slow走1步，相同时间下 fast走过的路程= 2* slow走过的路程
     * 如果两者相遇，fast比slow多走n圈。
     * fast_distance = 2 * slow_distance
     * fast_distance = slow_distance  + n * b(链表圈)
     * slow_distance = n*b
     * 链表只要走a + n * b一定会到入环口，n = 0，1,2,3,结果都一样。
     * 这是slow已经走了n * b，只要再走a就到链表口了
     */
    public static class Solution {
        public ListNode detectCycle(ListNode head) {
           ListNode fast = head, slow = head;
           while (true) {
               if (fast == null || fast.next == null) {
                   return null;
               }
               fast = fast.next.next;
               slow = slow.next;
               if (fast == slow) break;;
           }

           fast = head;
           while (fast != slow) {
               fast = fast.next;
               slow = slow.next;
           }
           return fast;
        }
    }
}
// fast = 2 * slow
// fast = slow + n*圈  slow = nb
