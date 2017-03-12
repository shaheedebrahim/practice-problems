import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();
        int s = input.nextInt();

        while (n != 0){
            long[][] map = new long[n][n];
            
            long max = Long.valueOf(1000000000);
            for (int i = 0; i < n; i++){
                Arrays.fill(map[i], max);
            }

            for (int i = 0; i < m; i++){
                int u = input.nextInt();
                int v = input.nextInt();
                int w = input.nextInt();

                map[u][v] = w;
            }

            for (int k = 0; k < n; k++){
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            for (int i = 0; i < q; i++){
                int temp = input.nextInt();
                if(map[temp][temp] < 0){
                    System.out.println("-Infinity");
                }else if (map[s][temp] == max) {
                    System.out.println("Impossible");
                }else{
                    System.out.println(map[s][temp]);
                }
            }

/**            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }**/
            
            System.out.println();

            n = input.nextInt();
            m = input.nextInt();
            q = input.nextInt();
            s = input.nextInt();
        }
    }
}
