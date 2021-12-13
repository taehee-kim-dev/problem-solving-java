package leetcode.q1669;

class ListNode {
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

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode currentNodeOfList1 = list1;
        int currentIndex = 0;
        while (currentIndex < a - 1) {
            currentNodeOfList1 = currentNodeOfList1.next;
            currentIndex ++;
        }
        ListNode beforeNodeOfRemovedNodeOfList1 = currentNodeOfList1;
        while (currentIndex < b) {
            currentNodeOfList1 = currentNodeOfList1.next;
            currentIndex++;
        }
        ListNode nextNodeOfRemovedNodeOfList1 = currentNodeOfList1.next;
        currentNodeOfList1.next = null;
        beforeNodeOfRemovedNodeOfList1.next = list2;
        ListNode currentNodeOfList2 = list2;
        while (currentNodeOfList2.next != null) {
            currentNodeOfList2 = currentNodeOfList2.next;
        }
        currentNodeOfList2.next = nextNodeOfRemovedNodeOfList1;
        return list1;
    }
}