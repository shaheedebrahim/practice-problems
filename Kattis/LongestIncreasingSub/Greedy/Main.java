import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int max = 100005;
            int n = input.nextInt();
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++){
                a[i] = input.nextInt();
            }

            int[] L_id = new int[max], P = new int[max];
            Vector<Integer> L = new Vector<Integer>();
            int lis = 0;
            int lis_end = 0;

            for (int i = 0; i < n; ++i){
                int pos = Collections.binarySearch(L, a[i]);
                if (pos < 0) pos = -(pos + 1);
                if (pos >= L.size()) L.add(a[i]);
                else L.set(pos,a[i]);

                L_id[pos] = i;
                P[i] = pos > 0 ? L_id[pos-1] : -1;
                if (pos + 1 > lis){
                    lis = pos + 1;
                    lis_end = i;
                }
            }
            
            Stack<Integer> s = new Stack();
            int x = lis_end;
            int size = 1;
            for (; P[x] >=0; x = P[x]){
                size++;
                s.push(x);
            }

            System.out.println(size);
            System.out.print(x);

            for (; !s.isEmpty(); s.pop()) System.out.print(" "+s.peek());
            System.out.println();
        }
    }
}
