import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        double mem[] = new double[1000010];
        mem[0] = 0;
        for (int i = 1; i < mem.length; i++){
            mem[i] = Math.log10(i) + mem[i-1];
        }

        while (input.hasNextInt()){
            int n = input.nextInt();
            n = (int)(Math.floor(mem[n]) + 1);
            System.out.println(n);
        }
    }
}
