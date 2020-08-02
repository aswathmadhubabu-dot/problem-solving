import java.util.Iterator;
import java.util.LinkedList;

class MyLinkedList {

    Node head = null;
    public static class Node
    {

        Node next;
        int data;
        public Node(int x)
        {
            this.data = x;
            this.next = null;
        }
    }

    public static MyLinkedList insert (int x, MyLinkedList list)
    {
        Node tmp = new Node(x);
        tmp.next = null;
        if(list.head == null)
        {
            list.head = tmp;
            return list;
        }
        else
        {
            Node iterator = list.head;

            while(iterator.next != null)
            {
                iterator = iterator.next;
            }
            iterator.next = tmp;

            list.head = iterator;

            return list;
        }

    }

    public static void main (String[] args)
    {
        MyLinkedList list = new MyLinkedList();

        insert(2, list);
        insert(3, list);

        Node tmp = list.head;
        while(tmp != null)
        {
            System.out.print(tmp.data);
            tmp = tmp.next;
        }

    }
}
