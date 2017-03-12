import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int test = 0; test < t; test++){
            int s = input.nextInt();
            int n = input.nextInt();

            int bills[] = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++){
                int temp = input.nextInt();
                sum+=temp;
                bills[i] = temp;
            }

            int mem[][] = new int[sum+1][n+1];
            for (int i = 0; i < sum+1; i++){
                for (int j = 0; j < bills.length; j++){
                    mem[i][j]+=1;
                }
                mem[i][n] = n+2;
            }

            mem[0][n] = 0;
            for (int i = 1; i < mem.length; i++){
                int min = n+1;
                for (int j = 0; j < bills.length; j++){
                    if (bills[j] <= i && mem[i - bills[j]][j] > 0 && 1 + mem[i - bills[j]][n] < min){
                        min = 1 + mem[i - bills[j]][n];
                        mem[i][n] = min;
                        mem[i][j] = mem[i - bills[j]][j] - 1;
                    }
                }
                if (i >= s && mem[i][n] != n+2){
                    System.out.println(i + " "+ mem[i][n]);
                    break;
                }
            }
        }
    }
}
