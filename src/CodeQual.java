import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CodeQual {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 4, 5));
        System.out.println(list);
        customSort(list);
        try {
            Integer.parseInt("011111111111111111111111111111111", 2);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    /*
        1 1 1 1 1 1 1
        2 1 1 1 1 1
        1 2 1 1 1 1
        1 1 2 1 1 1
        1 1 1 2 1 1
        1 1 1 1 2 1
        1 1 1 1 1 2
        1 2 2 1 1
        2 2 1 1 1
        1 1 2 2 1
        1 1 1 2 2
        2 2 2 1

     */
    public static void customSort(List<Integer> arr) {
//        Map<Integer, Integer> count = new HashMap<>();
//        for(Integer i: arr){
//            if(count.containsKey(i)){
//                int x = count.get(i);
//                count.put(i,++x);
//            }
//            else count.put(i, 1);
//        }
//        List<Integer> counts = new ArrayList<>();
//        for(Integer i :count.keySet()){
//            counts.add(count.get(i));
//        }
//        Collections.sort(counts);
//        counts = new ArrayList<>(new LinkedHashSet<>(counts));
//        for(Integer i:counts){
//            List<Integer> res = new ArrayList<>();
//            for(Integer c : count.keySet()){
//                if(i.intValue() == count.get(c).intValue()){for(int k=0;k<i;k++)res.add(c);}
//            }
//            Collections.sort(res);
//            for(Integer x:res){
//                System.out.println(x);
//            }
//        }
        Scanner scan = new Scanner(System.in);


        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);


    }
}
