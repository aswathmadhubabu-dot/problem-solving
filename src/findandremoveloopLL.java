public class findandremoveloopLL {
    int data;
    findandremoveloopLL next;

    public findandremoveloopLL(int x){
        this.data = x;
        this.next = null;
    }

    public static void main(String[] args) {
        findandremoveloopLL linkedList = new findandremoveloopLL(1);
        linkedList.next = new findandremoveloopLL(2);
        linkedList.next.next = new findandremoveloopLL(3);
        linkedList.next.next.next = new findandremoveloopLL(4);
        linkedList.next.next.next.next = new findandremoveloopLL(5);
        linkedList.next.next.next.next.next = new findandremoveloopLL(6);
        linkedList.next.next.next.next.next.next = new findandremoveloopLL(7);
        linkedList.next.next.next.next.next.next.next = linkedList.next.next.next;

        boolean isLoop = false;
        findandremoveloopLL slowPointer = linkedList;
        findandremoveloopLL fastPointer = linkedList;

        while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer) {
                isLoop = true;
                break;
            }
        }

        if(isLoop)
            System.out.println("Loop detected");

        // remove loop
        slowPointer = linkedList;
        while(slowPointer != fastPointer.next) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        fastPointer.next = null;

    }



}