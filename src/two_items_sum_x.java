import java.util.HashMap;

public class two_items_sum_x {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int x = 5;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i =0; i< arr.length; i++) {
           hm.put(i, arr[i]);
        }

        for(int j =0; j< arr.length; j++){
            if(hm.containsValue(x-arr[j])) {
                System.out.print(j);
            }
        }
    }
}
