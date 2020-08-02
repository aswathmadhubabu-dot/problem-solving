
import java.util.*;
import java.lang.*;
import java.io.*;

class Permuatationsofstring {

    public static void printAllPermutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printAllPermutations(ros, ans + ch);

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T >= 0) {
            String str = in.nextLine();
            printAllPermutations(str, "");
            T--;
        }
    }
}