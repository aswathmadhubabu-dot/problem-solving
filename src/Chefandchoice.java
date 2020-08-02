import java.util.Scanner;

public class Chefandchoice {
    public static void main(String[] args) throws java.lang.Exception{
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int N = in.nextInt();
            int[] items = new int[N];
            for(int i =0; i< N; i++) {
                items[i] = in.nextInt();
            }
            int Q = in.nextInt();
            while(Q > 0) {
                int start = in.nextInt();
                int end = in.nextInt();
                int minimumcost = in.nextInt();
                int sum = 0;
                for(int j = start - 1; j<= end-1 ; j++) {
                    if(items[j] < minimumcost)
                        sum+=items[j];
                }
                if(sum >= minimumcost)
                    System.out.print(sum);
                else
                    System.out.print(-1);

                Q--;
            }
            break;
        }
    }
}
