import java.util.*;
import java.math.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++){
            double n = input.nextDouble();
            double v1 = input.nextDouble();
            double v2 = input.nextDouble();
            double w = input.nextDouble();

            double needed = Math.floor(n/2) + 1 - v1;
            double remaining = n - (v1 + v2);

            if ((v1 / n) > 0.5){
                System.out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
            }else if ((v2 / n) >= 0.5){
                System.out.println("RECOUNT!");
            }else{
                double cumProb = 0;
                for (double j = needed; j <= remaining; j++){
                    cumProb += binom(remaining, j);
                }

                if (cumProb*100> w){
                    System.out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
                }else{
                    System.out.println("PATIENCE, EVERYONE!");
                }
            }

        }
    }

    public static double binom (double n , double k){
        double comb = factorial(n) / (factorial(k)*factorial(n - k));
        comb = comb*(Math.pow(0.5, k));
        comb = comb*Math.pow(0.5, n - k);
        return comb;
    }

    public static double factorial (double n){
        if (n == 0) return 1;
        double ans = n;
        for (double i = n-1; i >0; i--){
            ans*=i;
        }
        return ans;
    }
}
