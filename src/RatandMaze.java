public class RatandMaze {
    private static int N;
    private int soln[][];
    private static boolean FindMaze(int[][] maze, int x, int y, int[][] soln) {
        if (x == N - 1 && y == N - 1) {
            soln[x][y] = 1;
            return true;
        }
        if (x >= 0 && x < N  && y >= 0 && y < N  && maze[x][y] == 1) {
            soln[x][y] = 1;

            if (FindMaze(maze, x + 1, y, soln))
                return true;
            if (FindMaze(maze, x, y + 1, soln))
                return true;

            soln[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        RatandMaze r = new RatandMaze();
        int maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        N = maze.length;
        int soln[][] = new int[N][N];
        if (FindMaze(maze, 0, 0, soln)){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(soln[i][j]);
                }
                System.out.println();
            }
        }
        else
            System.out.println("no paths found");

    }
}
