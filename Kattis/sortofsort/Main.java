import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        while (n!=0){
            String names[] = new String[n];
            for (int i = 0; i < n; i++){
                names[i] = input.nextLine();
            }
            Comparator<String> firstTwo = new Comparator<String>(){
                @Override
                public int compare(String o1, String o2){
                    if (o1.length() >= 2) o1 = o1.substring(0,2);
                    if (o2.length() >=2 ) o2 = o2.substring(0,2);
                    return o1.compareTo(o2);
                }
            };
            Arrays.sort(names, firstTwo);

            for (int i = 0; i < n; i++){
                System.out.println(names[i]);
            }
            System.out.println();
            n = input.nextInt();
            input.nextLine();
        }
    }
}
