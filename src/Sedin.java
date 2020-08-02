public class Sedin {

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,3,3,3,4};
        int k = 3;

        int n = arr.length;
        int[] temp = new int[k];

        for(int i=0; i<n ; i++) {
            temp[arr[i] %k] += 1;
        }

        int s = (temp[0] * temp[0]-1) /2;

        for(int i =1; i<=k/2; i++) {
            s+= temp[i] * temp[k-i];
        }

        if(k%2 ==0) {
            s+= temp[k/2] * (temp[k/2] -1) /2;
        }

        System.out.println(s);
    }

    // n = 5
    // k =3
    // i 0 i 1 i 2
    // tmp [1] 3
    /// tmp [2 % 3] tmp[2] 1
    /// tmp [3%3] tmp[0] 1
    // s = 1 * 0 / 2 =0
    // 3/ 2 = 1
    // s+= tmp[1] * tmp[k-1]
    // 3 * 1
    // 3
}
