import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class textjustification {

    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();
        input.add("This");
        input.add("is");
        input.add("an");
        input.add("example");
        input.add("of");
        input.add("text");
        input.add("justification");
        int L = 16;
        List<String> result = new ArrayList<String>();
        result.add("");
        result.add("");
        result.add("");
        int iter = 0;
        int k = 0;
        while(iter < input.size()) {
            while((result.get(k).length() + input.get(iter).length()) < L ) {
                result.set(k, result.get(k) + input.get(iter));
                result.set(k, result.get(k) + ' ');
                iter++;
                if(iter >= input.size()) {
                    break;
                }
            }
            k++;
        }

        System.out.println(Arrays.toString(result.toArray()));
    }
}
