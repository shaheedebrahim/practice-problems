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

            int mem[] = new int[sum+1];
            Arrays.fill(mem, n+2);
            mem[0] = 0;

            for (int i = 0; i < mem.length; i++){
                int min = n+1;
                for (int j = 0; j < bills.length; j++){
                    if (bills[j] <= i && 1 + mem[i - bills[j]] < min){
                        min = 1 + mem[i - bills[j]];
                        mem[i] = min;
                    }
                }
                if (i >= s && mem[i] != n+2){
                    System.out.println(i + " "+ mem[i]);
                    break;
                }
            }
        }
    }
}
