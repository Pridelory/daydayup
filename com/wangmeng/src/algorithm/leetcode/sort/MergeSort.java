package algorithm.leetcode.sort;

/**
 * @ClassName MergeSort
 * @Description single linked list merge sort
 * @Author wangmeng
 * @Date 2021/12/30
 */
public class MergeSort {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-1);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(0);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = new MergeSort().sortList(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode sortList(ListNode head) {
        return sortListRecursively(head);
    }

    public ListNode sortListRecursively(ListNode head) {
        // sanity check
        if (head == null || head.next == null) return head;

        // 1. look for the mid node given head and tail
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                prev = slow;
            }
            slow = slow.next;
        }
        prev.next = null;

        ListNode mid = slow;
        ListNode left = sortListRecursively(head);
        ListNode right = sortListRecursively(mid);

        // 2. merge two lists
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
