import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        
        while (input.hasNext()){
            int n = input.nextInt();
            int[] mem = new int[n];
            int[] seq = new int[n];

            for (int i = 0; i < n; i++){
                seq[i] = input.nextInt();
            }

            Stack[] s = new Stack[n];
            for (int i = 0; i < n; i++){
                s[i] = new Stack();
            }

            mem[n-1] = 1;
            s[n-1].add(n-1);
            for (int i = n-2; i >= 0; i--){
                int max = 0;
                int index = -1;
                for (int j = i; j < n; j++){
                    if (seq[i] < seq[j] && mem[j] > max){
                        max = mem[j];
                        index = j;
                    }
                }
                mem[i] = max + 1;
                if (index == -1){
                    Stack temp = new Stack();
                    temp.push(i);
                    s[i] = temp;
                }else{
                    Stack temp = (Stack)s[index].clone();
                    temp.push(i);
                    s[i] = temp;
                }
            }

            int largest = 0;
            int index = 0;
            for (int i = 0; i < n; i++){
                if (mem[i] > largest){
                    largest = mem[i];
                    index = i;
                }
            }
            System.out.println(largest);
            Stack temp = s[index];
            while (!temp.isEmpty()){
                System.out.print(temp.pop()+" ");
            }
            System.out.println();

        }
    }
}
