
import java.io.*;
import java.util.*;

interface OInterFace{
    int getmin();
    int getmax();
    boolean isEven();
};

public class OOps implements  OInterFace{


    @Override
    public int getmin() {
        return 0;
    }

    @Override
    public int getmax() {
        return 0;
    }

    @Override
    public boolean isEven() {
        return false;
    }

    public static abstract class A {


        private int a;
        private int b;

        public int getSum(int x, int y)
        {
            this.a = x;
            this.b = y;

            return x+y;
        }

        public abstract void print();

    }

    public static class B extends A{

        @Override
        public void print()
        {
            System.out.println("lah lah");
        }

    }

    static public void main(String[] args)
    {
//        B b = new B();
//       System.out.println(b.getSum(2 ,3));
//       b.print();
//
//       OOps oo = new OOps();
//       System.out.println(oo.getmin());
//
//        int i;
//        Integer a = Integer.parseInt("-(1+2+3)");
//        System.out.println(a);
//        do{i++;}while (i<0);
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(4);
        pq.add(2);
        pq.add(9);

        Queue<Integer> ps = new PriorityQueue<>();
        ps.add(4);
        ps.add(2);
        ps.add(9);
        ps.add(1);
        ps.add(0);

        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(ps);
        System.out.println(ps.poll());
        System.out.println(ps.poll());
        System.out.println(ps.poll());
        System.out.println(ps.poll());
//
//        System.out.println(7 % 8);
//        System.out.println(7 /8);
//        String str = "jumble";
//        int a = (int) str.charAt(3);
//        System.out.print(a);
//
//        char f = 97;
//        System.out.print(f);
//
//        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
//        map.put(1, new Pair(2,3));
//        System.out.print(map);
//        System.out.print(1/2);
    }
}
