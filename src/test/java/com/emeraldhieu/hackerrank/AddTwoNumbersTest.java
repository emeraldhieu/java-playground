package com.emeraldhieu.hackerrank;

import com.emeraldhieu.hackerrank.AddTwoNumbers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersTest {
    private final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    public void case1() {
        // GIVEN
        var l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        var l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // WHEN
        var headNode = addTwoNumbers.addTwoNumbers(l1, l2);

        // THEN
        var resultList = getList(headNode);
        assertEquals(List.of(7, 0, 8), resultList);
    }

    private List<Integer> getList(ListNode listNode) {
        var list = new ArrayList<Integer>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    @Test
    public void case2() {
        // GIVEN
        var l1 = new ListNode(0);

        var l2 = new ListNode(0);

        // WHEN
        var headNode = addTwoNumbers.addTwoNumbers(l1, l2);

        // THEN
        var resultList = getList(headNode);
        assertEquals(List.of(0), resultList);
    }

    @Test
    public void case3() {
        // GIVEN
        var l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        var l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        // WHEN
        var headNode = addTwoNumbers.addTwoNumbers(l1, l2);

        // THEN
        var resultList = getList(headNode);
        assertEquals(List.of(8, 9, 9, 9, 0, 0, 0, 1), resultList);
    }

    @Test
    public void case4() {
        // GIVEN
        var l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(1);

        var l2 = new ListNode(1);

        // WHEN
        var headNode = addTwoNumbers.addTwoNumbers(l1, l2);

        // THEN
        var resultList = getList(headNode);
        assertEquals(List.of(0, 0, 2), resultList);
    }

    @Test
    public void case5() {
        // GIVEN
        var l1 = new ListNode(5);

        var l2 = new ListNode(5);

        // WHEN
        var headNode = addTwoNumbers.addTwoNumbers(l1, l2);

        // THEN
        var resultList = getList(headNode);
        assertEquals(List.of(0, 1), resultList);
    }
}