import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        double ans = 0;
        double multiplier = 1;
        double[] probs = new double[n];
        for (int i = 0; i < n; i++){
            probs[i] = Double.parseDouble(input.nextLine().split(" ")[1]);
        }

        Arrays.sort(probs);

        for (int i = n-1; i >=0; i--){
            ans += (multiplier * probs[i]);
            multiplier++;
        }

        System.out.printf("%.4f\n", ans);
    }
}
