public class SwapNodesInPairs {
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

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode leftPtr = head;
        ListNode temp = new ListNode(-99);
        ListNode previous = temp;

        while (leftPtr != null && leftPtr.next != null) {
            previous.next = leftPtr.next;
            leftPtr.next = leftPtr.next.next;
            previous.next.next = leftPtr;
            leftPtr = leftPtr.next;
            previous = previous.next.next;
        }
        return temp.next;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode head = swapPairs(listNode);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
