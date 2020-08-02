public class MergeSortLL {
    private int data;
    MergeSortLL next;

    public MergeSortLL(int x) {
        this.data = x;
        this.next = null;
    }

    private static MergeSortLL SortandMerge(MergeSortLL A, MergeSortLL B) {
        if (A == null)
            return B;
        if (B == null)
            return A;

        if (A.data < B.data) {
            A.next = SortandMerge(A.next, B);
            return A;
        } else {
            B.next = SortandMerge(A, B.next);
            return B;
        }
    }

    private static MergeSortLL ReverseLinkedList(MergeSortLL A) {

        MergeSortLL current = A;
        MergeSortLL next = null;
        MergeSortLL prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        A = prev;
        return A;
    }

    public static void main(String[] args) {
        MergeSortLL linkedList1 = new MergeSortLL(2);
        linkedList1.next = new MergeSortLL(4);
        linkedList1.next.next = new MergeSortLL(6);

        MergeSortLL linkedList2 = new MergeSortLL(1);
        linkedList2.next = new MergeSortLL(3);
        linkedList2.next.next = new MergeSortLL(5);

        MergeSortLL finall = SortandMerge(linkedList1, linkedList2);

        while (finall.next != null) {
            System.out.println(finall.data);
            finall = finall.next;
        }

        MergeSortLL reverseList = ReverseLinkedList(linkedList1);

        while (reverseList.next != null) {
            System.out.println(reverseList.data);
            reverseList = reverseList.next;
        }
    }
}
