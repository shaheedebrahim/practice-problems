/**
 * A better approach to this problem would be using functional methods to map the kernel
 * to the image
**/
import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        int h = input.nextInt();
        int w = input.nextInt();
        int n = input.nextInt();
        int m = input.nextInt();

        int[][] image = new int[h][w];
        int[][] kernel = new int[n][m];

        //Set image
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                image[i][j] = input.nextInt();
            }
        }
        //Set kernel
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                kernel[i][j] = input.nextInt();
            }
        }

        kernel = flipRows(kernel);
        kernel = flipCols(kernel);

        int rows = h - n + 1;
        int cols = w - m + 1;

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                int sum = 0;
                for (int x = 0; x < n; x++){
                    for (int y = 0; y < m; y++){
                        sum += kernel[x][y] * image[i+x][j+y];
                    }
                }

                result[i][j] = sum;
            }
        }
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static int[][] flipRows(int[][] kernel){
        int[][] reversed = new int[kernel.length][kernel[0].length];
        for (int i = 0; i < kernel.length; i++){
            for (int j = 0; j < kernel[0].length; j++){
                reversed[i][j] = kernel[i][kernel[0].length - 1 - j];
            }
        }
        return reversed;
    }
    public static int[][] flipCols(int[][] kernel){
        int[][] reversed = new int[kernel.length][kernel[0].length];
        for (int col = 0; col < kernel[0].length; col++){
            for (int row = 0; row < kernel.length; row++){
               reversed[row][col] = kernel[kernel.length - 1 - row][col]; 
            }
        }
        return reversed;
    }
}
