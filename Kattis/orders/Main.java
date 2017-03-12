import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in); int n = input.nextInt();
        int[] c = new int[n];

        for (int i = 0; i < n; i++){
            c[i] = input.nextInt();
        }

        int m = input.nextInt(); int[] s = new int[m];

        for (int i = 0; i < m; i++){
            s[i] = input.nextInt();
        }

        int[] u = s.clone();
        Arrays.sort(u);
        int max = u[u.length-1];

        int[][] mem = new int[max+1][c.length];

        for (int i = 0; i < max+1; i++){
            Arrays.fill(mem[i], Integer.MAX_VALUE);
        }
        Arrays.fill(mem[0], 0);

        for (int i = 1; i < max+1; i++){
            int counter = 0;
            for (int j = 0; j < c.length; j++){
                if (c[j] <= i){
                    int[] temp = mem[i-c[j]].clone();
                    if (temp[0] < 0){
                        Arrays.fill(mem[i], -1);
                        break;
                    }else if (temp[0] != Integer.MAX_VALUE){
                        temp[j] += 1;
                        if (!Arrays.equals(temp,mem[i])){
                            if (counter >= 1){
                                Arrays.fill(mem[i], -1);
                            }else{
                                mem[i] = temp.clone();
                                counter++;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++){
            int[] temp = mem[s[i]].clone();
            if (temp[0] < 0) System.out.println("Ambiguous");
            else if (temp[0] == Integer.MAX_VALUE) System.out.println("Impossible");
            else{
                for (int j = 0; j < temp.length; j++){
                    while (temp[j] > 0){
                        if (j == temp.length -1 && temp[j] == 1){
                            System.out.print(j+1);
                            temp[j]--;
                        }else{
                            System.out.print(j+1+" ");
                            temp[j]--;
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    public static void printMem(int[][] mem){
        for (int i = 0; i < mem.length; i++){
            for (int j = 0; j < mem[i].length; j++){
                System.out.print(mem[i][j]+" ");
            }
            System.out.println();
        }
    }
}
