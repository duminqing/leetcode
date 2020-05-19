package com.leetcode1;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class N206 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode list = new Solution().reverseList(head1);
        System.out.println(list);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur.next != null) {
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = pre;
                pre = tmp;
            }
            cur.next = pre;
            return cur;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur.next != null) {
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = pre;
                pre = tmp;
            }
            cur.next = pre;
            return cur;
        }
    }
}
