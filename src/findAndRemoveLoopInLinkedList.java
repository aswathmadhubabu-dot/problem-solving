class findAndRemoveLoopInLinkedList {

    static class LinkedList {
        int data;
        LinkedList next;

        public LinkedList(int x) {
            this.data = x;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Looped list
        LinkedList linkedList = new LinkedList(50);
        linkedList.next = new LinkedList(20);
        linkedList.next.next = new LinkedList(15);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(10);
        linkedList.next.next.next.next.next = linkedList.next.next;

        LinkedList slowPointer = linkedList;
        LinkedList fastPointer = linkedList;

        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;

        while (fastPointer != null && fastPointer.next != null) {
            if (slowPointer == fastPointer) {
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (slowPointer == fastPointer) {
            slowPointer = linkedList;
            if (slowPointer != fastPointer) {
                while (slowPointer.next != fastPointer.next) {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
                fastPointer.next = null;
            } else {
                while (fastPointer.next != slowPointer) {
                    fastPointer = fastPointer.next;
                }
                fastPointer.next = null;
            }
        }

        LinkedList head = linkedList;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

}