import java.util.ArrayList;
import java.util.Collections;

public class MergeKsortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return new ListNode(0);

        if(lists.length == 1)
        {
            return lists[0];
        }

        else if(lists[0] != null) {
            ListNode tmp = lists[0];

            for(int i =1; i< lists.length ;i++)
            {
                if(lists[i] != null)
                    tmp.next = lists[i];
            }

            ListNode ln  = tmp;
            ArrayList<Integer> arr = new ArrayList();
            while(ln.next !=null)
            {
                arr.add(ln.val);
                ln = ln.next;
            }
            Collections.sort(arr);


            ListNode fina = new ListNode( (arr.get(0) != null) ? arr.get(0): 0);

            for(int i =1; i< arr.size(); i++)
            {
                fina.next = new ListNode(arr.get(i));
                fina = fina.next;
            }
        }
        return new ListNode(0);
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(4);
        ln.next.next = new ListNode(5);

        ListNode an = new ListNode(1);
        an.next = new ListNode(3);
        an.next.next = new ListNode(4);

        ListNode bn = new ListNode(2);
        bn.next = new ListNode(6);

        ListNode[] lnarray = {ln, an, bn};
        mergeKLists(lnarray);
    }
}
