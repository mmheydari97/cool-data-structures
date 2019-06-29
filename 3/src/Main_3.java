import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // initial number of vertices
        int sizeN = input.nextInt();

        // find shortest path of all initial vertices
        int[][] a = new int[sizeN][sizeN];
        for (int i = 0; i < sizeN ; i++) {
            for (int j = 0; j < sizeN ; j++) {
                a[i][j] = input.nextInt();
            }
        }

        // k is the number of edges to be added
        int k = input.nextInt();

        for (int i = 0; i < sizeN; i++) {
            shortest_path(a, i);
        }

        for (int i = 0; i < k ; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int value = input.nextInt();
            if (value < a[u-1][v-1]) {
                a[u - 1][v - 1] = value;
                a[v-1][u-1] = value;
            }

            shortest_path(a,u-1);
            shortest_path(a,v-1);

            int s = 0;
            for (int j = 1; j < a.length ; j++) {
                for (int l = 0; l < a.length-1 ; l++) {
                    if (j > l)
                        s += a[j][l];
                }
            }
            System.out.printf("%d ",s);
        }
    }

    private static void shortest_path(int[][] a, int u){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] > a[i][u]+a[u][j]){
                    a[i][j] = a[i][u]+a[u][j];
                }
            }
        }

    }
}