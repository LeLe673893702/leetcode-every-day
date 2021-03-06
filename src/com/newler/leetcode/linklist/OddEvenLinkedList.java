package com.newler.leetcode.linklist;
// [328]、奇偶链表
// 2020年4月16日09:46:14
//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
//
// 输入 1->2->3->4->5->null
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7-> 1->5->4->NULL
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表


import com.newler.leetcode.data.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = new ListNode(nums);

        Solution solution = new Solution();
        solution.oddEvenList(head);
    }
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;
            ListNode oddCur = head;
            ListNode evenCur = head.next;
            ListNode evenHead = head.next;
            ListNode oddPre = null;
            ListNode evenPre = null;

            while (oddCur != null && oddCur.next != null && evenCur != null && evenCur.next != null) {
                oddCur.next = oddCur.next.next;

                evenCur.next = evenCur.next.next;

                oddPre = oddCur;
                oddCur = oddCur.next;
                evenPre = evenCur;
                evenCur = evenCur.next;
            }

            if (evenCur != null && evenCur.next != null) {
                evenCur.next = null;
            } else if (evenCur == null && evenPre != null) {
                evenPre.next = null;
            }


            if (oddCur == null) {
                oddCur = oddPre;
            }

            oddCur.next = evenHead;

            return head;

        }
    }
}

