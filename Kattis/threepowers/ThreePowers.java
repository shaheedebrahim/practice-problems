import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ar-tran.anna on 11/16/16.
 */
public class ThreePowers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger[] cache = createCache();
        double n = in.nextDouble() - 1;
        System.out.println(n);


        while (n != -1) {
            ArrayList<Integer> exponents = new ArrayList();
            while (n != 0) {
                int anExponent = (int) Math.floor(Math.log(n) / Math.log(2));
                System.out.println(anExponent);
                exponents.add(anExponent);
//                System.out.println("added exponent " + anExponent);
                n = n - Math.pow(2, anExponent);
//                System.out.println("n is now: " + m);
            }
            Collections.sort(exponents);

            System.out.print("{");
            for (int i = 0 ; i < exponents.size() ; i++) {
                int exponent = exponents.get(i);
                System.out.print(" "+cache[exponent].toString());
                if (i != exponents.size()-1)
                    System.out.print(",");

            }
            System.out.println(" }");

            n = in.nextDouble() - 1;
        }
    }

    public static BigInteger[] createCache() {
        BigInteger[] cache = new BigInteger[68];
        cache[0] = BigInteger.valueOf(1);
        for (int i = 1; i < 68; i++) {
            cache[i] = BigInteger.valueOf(3).multiply(cache[i-1]);
        }
        return cache;
    }

}
