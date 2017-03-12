import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int h = input.nextInt();
        int m = input.nextInt();

        int timeDif = 45;

        if (m - timeDif < 0){
            if (h == 0){
                h = 23;
                m = 60 - (timeDif - m);
            }else{
                h = h-1;
                m = 60 - (timeDif - m);
            }
        }else{
            m = m -timeDif;
        }

        System.out.print(h+" "+m);
    }
}
