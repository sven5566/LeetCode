package com.whr.leetcode.easy;

/**
 * Leet Code OJ 21. Merge Two Sorted Lists [Difficulty: Easy]
 * 题目:
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * 翻译:
 * 合并2个已经排序的链表，并且返回一个新的链表。这个新的链表应该由前面提到的2个链表的节点所组成。
 * <p>
 * 分析：
 * 注意头节点的处理，和链表结束（next为null）的处理。以下代码新增了一个头指针，来把头节点的处理和普通节点的处理统一了。
 */
public class MergeTwoSortedLists {
	public static void main(String[] args) {

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode currentNode = head;
		while (true) {
			if (l1 == null && l2 == null) {
				break;
			} else if (l2 != null && (l1 == null || l1.val > l2.val)) {
				currentNode.next = l2;
				l2 = l2.next;
			} else {
				currentNode.next = l1;
				l1 = l1.next;
			}
			currentNode = currentNode.next;
		}
		return head.next;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
