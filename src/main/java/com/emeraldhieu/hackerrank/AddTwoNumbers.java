package com.emeraldhieu.hackerrank;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Examples:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * ---
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * ---
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * ---
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 * ---
 * See https://leetcode.com/problems/add-two-numbers
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;

        /**
         * The number of nodes in each linked list is in the range [1, 100].
         * Thus, handle the first node.
         */
        int firstAddition = node1.val + node2.val;
        int carriedDigit = firstAddition >= 10 ? 1 : 0;
        int firstSum = firstAddition % 10;
        ListNode sumNode = new ListNode(firstSum);
        ListNode sumHeadNode = sumNode;

        node1 = node1.next;
        node2 = node2.next;

        // Handle n+1 node.
        while (node1 != null || node2 != null) {

            if (node1 != null && node2 != null) {
                int addition = node1.val + node2.val + carriedDigit;
                carriedDigit = addition >= 10 ? 1 : 0;
                int sum = addition % 10;
                sumNode.next = new ListNode(sum);
                sumNode = sumNode.next;

            } else if (node1 != null && node2 == null) {
                int addition = node1.val + carriedDigit;
                carriedDigit = addition >= 10 ? 1 : 0;
                int sum = addition % 10;
                sumNode.next = new ListNode(sum);
                sumNode = sumNode.next;

                if (carriedDigit > 0 && node1.next == null) {
                    ListNode lastSumNode = new ListNode(carriedDigit);
                    sumNode.next = lastSumNode;
                    sumNode = sumNode.next;
                    carriedDigit = -1;
                }
            } else if (node1 == null && node2 != null) {
                int addition = node2.val + carriedDigit;
                carriedDigit = addition >= 10 ? 1 : 0;
                int sum = addition % 10;
                ListNode resultNode2 = new ListNode(sum);

                sumNode.next = resultNode2;
                sumNode = sumNode.next;

                if (carriedDigit > 0 && node2.next == null) {
                    ListNode lastSumNode = new ListNode(carriedDigit);
                    sumNode.next = lastSumNode;
                    sumNode = sumNode.next;
                    carriedDigit = -1;
                }
            }

            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }
        }

        if (carriedDigit > 0) {
            ListNode lastSumNode = new ListNode(carriedDigit);
            sumNode.next = lastSumNode;
        }

        return sumHeadNode;
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
