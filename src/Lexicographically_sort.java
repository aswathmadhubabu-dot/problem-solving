
import java.util.Arrays;

public class Lexicographically_sort {
    public static int factorial(int number)
    {
        if(number == 0){
            return 1;
        }
        return number*factorial(number -1);
    }

    public static void main (String[] args)
    {

//        String[] a = {"e", "en", "er", "ere", "ren", "eren", "n", "r", "re"};
//        Arrays.sort(a);
//        for(String i : a)
//        {
//            System.out.print(i);
//            System.out.print(" ");
//
//        }
        // Your code here
        long n = 42;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i <=n; i++)
        {
            sb.append(i);
        }

        String a = sb.toString();


        long count =0;

        for(int i =0 ; i<a.length(); i++)
        {
            if(a.charAt(i) == '2')
            {
                count++;
            }
        }
        System.out.println(count);



    }


}
