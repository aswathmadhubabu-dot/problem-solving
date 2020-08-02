import java.util.Scanner;

public class Handhsakes {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long T = in.nextLong();
            while(T >0)
            {
                long N = in.nextLong();
                long[] items = new long[(int) N];
                for(long i =0; i< N; i++) {
                    items[(int) i] = in.nextLong();
                }
                long sum = 0;
                for(long j = 0; j< N ; j++) {
                    if(items[(int) j] == 1)
                        sum+=items[(int) j];
                    else if(sum == 0) {
                        sum = 1;
                        sum*=items[(int) j];
                    }
                    else
                        sum*=items[(int) j];
                }
                System.out.println(sum);
                T--;
            }
            break;
        }
    }
}
