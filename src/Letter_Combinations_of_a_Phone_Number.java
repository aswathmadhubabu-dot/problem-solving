import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {

        HashMap<Integer, String> telePhoneNumber = new HashMap<Integer, String>();
        telePhoneNumber.put(1, "");
        telePhoneNumber.put(2, "abc");
        telePhoneNumber.put(3, "def");
        telePhoneNumber.put(4, "ghi");
        telePhoneNumber.put(5, "jkl");
        telePhoneNumber.put(6, "mno");
        telePhoneNumber.put(7, "pqrs");
        telePhoneNumber.put(8, "tuv");
        telePhoneNumber.put(9, "wxyz");

        String[] chars =  digits.split("");
        for (String aChar : chars) {
            int number = Integer.valueOf(aChar);
            telePhoneNumber.get(number);
        }

        return new ArrayList<>();
        
    }

    public void main (String[] args)
    {
        letterCombinations("23");
    }
}
