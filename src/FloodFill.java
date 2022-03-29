import java.util.Arrays;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int center = image[sr][sc];


        int currentColor = center;

        fillRecursively(image, sr, sc, currentColor, newColor);

        return image;

    }

    public static void fillRecursively(int[][] image, int sr, int sc,
                                       int currentColor, int newColor) {

        int m = image.length;
        int n = image[0].length;

        if (sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] == newColor || image[sr][sc] != currentColor)
            return;

        image[sr][sc] = newColor;

        fillRecursively(image, sr - 1, sc, currentColor, newColor);

        fillRecursively(image, sr + 1, sc, currentColor, newColor);

        fillRecursively(image, sr, sc - 1, currentColor, newColor);

        fillRecursively(image, sr, sc + 1, currentColor, newColor);

        return;

    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(image));
    }
}
