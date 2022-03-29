import java.util.List;

public class MergeKSortedLinkedList {

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

    public static ListNode mergeList(ListNode listA, ListNode listB) {
        if (listA == null)
            return listB;
        if (listB == null)
            return listA;

        if (listA.val <= listB.val) {
            listA.next = mergeList(listA.next, listB);
            return listA;
        }

        listB.next = mergeList(listA, listB.next);
        return listB;
    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(1);
        listNodeA.next = new ListNode(4);
        listNodeA.next.next = new ListNode(5);

        ListNode listNodeB = new ListNode(1);
        listNodeB.next = new ListNode(3);
        listNodeB.next.next = new ListNode(4);

        ListNode listNodeC = new ListNode(2);
        listNodeC.next = new ListNode(6);

        List<ListNode> listNodes = List.of(listNodeA, listNodeB, listNodeC);

        ListNode result = null;

        for (ListNode listNode : listNodes)
            result = mergeList(result, listNode);

//        ListNode listC = mergeList(listNodeA, listNodeB);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
