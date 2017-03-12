import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        while (m!=0 && n!=0){
            int coins = 0;
            ArrayList<Integer> heads = new ArrayList<Integer>();
            ArrayList<Integer> knights = new ArrayList<Integer>(); 

            for (int i = 0; i < n; i++){
                heads.add(input.nextInt());
            }
            for (int i = 0; i < m; i++){
                knights.add(input.nextInt());
            }

            if (m < n) System.out.println("Loowater is doomed!");
            else{
                Collections.sort(heads);
                Collections.sort(knights);

                boolean found = true;
                int index = -1;

                for (int i = 0; i < n; i++){
                    index = binarySearch(heads.get(i), knights);

                    if (index == -1){
                        System.out.println("Loowater is doomed!");
                        found = false;
                        break;
                    }

                    coins += knights.get(index);
                    knights.remove(index);
                }
                if (found) System.out.println(coins);
            }

            n = input.nextInt();
            m = input.nextInt();
       }

    }
    public static int binarySearch(int find, ArrayList<Integer> knights){
        int low = 0;
        int high = knights.size() - 1;
        if (knights.get(high) < find) return -1;
        else{
            int mid = -2;
            while (low <= high){
                mid = (low + high)/2;
                if (knights.get(mid) > find){
                    high = mid -1;
                }else if (knights.get(mid) < find){
                    low = mid + 1;
                }else{
                    return mid;
                }
            }
            for (int i = mid; i < knights.size(); i++){
                if (knights.get(i) >= find) return i;
            }
        }
        return -1;
    }
}





