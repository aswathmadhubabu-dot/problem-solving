public class Insert_node_in_middle_linkedlist {

    private int data;
    private Insert_node_in_middle_linkedlist next;

    private Insert_node_in_middle_linkedlist(int x){
        this.data = x;
        this.next = null;
    }

    private Insert_node_in_middle_linkedlist insertintomiddle(Insert_node_in_middle_linkedlist linkedlist, int x){
        Insert_node_in_middle_linkedlist head = linkedlist;
        Insert_node_in_middle_linkedlist slowptr = linkedlist;
        Insert_node_in_middle_linkedlist fastptr = linkedlist;

        while(fastptr.next.next !=null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }

        Insert_node_in_middle_linkedlist temp = new Insert_node_in_middle_linkedlist(x);
        temp.next = slowptr.next;
        slowptr.next = temp;

        return head;
    }

    public static void main(String[] args){
        Insert_node_in_middle_linkedlist ll = new Insert_node_in_middle_linkedlist(1);
        ll.next = new Insert_node_in_middle_linkedlist(2);
        ll.next.next = new Insert_node_in_middle_linkedlist(4);
        ll.next.next.next = new Insert_node_in_middle_linkedlist(5);
        Insert_node_in_middle_linkedlist fl = ll.insertintomiddle(ll, 3);


    }
}
