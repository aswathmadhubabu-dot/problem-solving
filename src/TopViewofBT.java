import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int n = secret.length();

        while(i < n) {
            Character currentChar = secret.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            i++;
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey()+ "-");
            System.out.print(entry.getValue());
            System.out.println();
        }

        int j = 0;
        int m = guess.length();

        while(j < m) {
            if(secret.charAt(j) == guess.charAt(j)) {
                bulls++;
                map.put(guess.charAt(j), map.get(guess.charAt(j)) - 1);
            }

            else if(map.containsKey(guess.charAt(j))) {
                System.out.println(map.get(guess.charAt(j)));
                map.put(guess.charAt(j), map.get(guess.charAt(j)) - 1);
                if(map.get(guess.charAt(j)) >= 0)
                    cows++;
            }

            j++;
        }

        return bulls + "A" + cows + "B";
    }
}