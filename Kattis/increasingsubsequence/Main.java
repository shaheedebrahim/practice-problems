/**
 * This problem is essentially the same as the longest inceasing subsequence with the
 * twist that we must ouput the lexicographically smallest sequence
 **/
import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();

        while (n!=0){
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++){
                sequence[i] = input.nextInt();
            }

            int[][] dp = new int[n][n+1];
            dp[0][0] = 1;
            dp[0][1] = sequence[0];
            int best = 1;
            int bestIndex = 0;

            /**
             * To reduce the complexity of finding the lexicographically smallest sequence we use a greedy solution
             * of always adding the current number to a sequence (if possible) with the lowest number at the end of the
             * existing sequence
             **/
            for (int i = 1; i < n; i++){
                int currentNumber = sequence[i];
                int currentBest = 1;
                int smallestNum = 999999999;
                int index = -1;
                for (int j = 0; j < n; j++){
                    if (i != j && currentNumber > dp[j][dp[j][0]]){
                        if ((dp[j][0] + 1 == currentBest && dp[j][dp[j][0]] < smallestNum) || (dp[j][0] + 1 > currentBest)){
                            smallestNum = dp[j][dp[j][0]];
                            currentBest = dp[j][0] + 1;
                            dp[i][0] = currentBest;
                            index = j;
                        }

                    }
                }
                if (index != -1){
                    for (int m = 1; m < currentBest; m++){
                        dp[i][m] = dp[index][m];
                    }
                }
                dp[i][currentBest] = currentNumber;
                if (currentBest > best){
                    bestIndex = i;
                    best = currentBest;
                }
            }
            
            /**
             * We may end up with the case where the last few indexes of our DP array all hold the same
             * length of sequence with different numbers, so we have to sort them
             * A radix sort may be better in this case, and we may also have been able to circumvent this issue
             * by doing the DP from top to bottom instead of bottom to top.
             **/
            ArrayList<ArrayList<Integer>> toSort = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n; i++){
                if (dp[i][0] == best){
                    ArrayList<Integer> temp = new ArrayList<Integer>();;
                    for (int j = 0; j < best+1; j++){
                       temp.add(dp[i][j]); 
                    }
                    toSort.add(temp);
                }
            }

            Comparator<ArrayList<Integer>> lexi = new Comparator<ArrayList<Integer>>(){
                @Override
                public int compare (ArrayList<Integer> o1, ArrayList<Integer> o2){
                    for (int i = 1; i < o1.size(); i++){
                        if (o1.get(i) < o2.get(i)) return -1;
                        if (o2.get(i) < o1.get(i)) return 1;
                    }
                    return 0;
                }
            };

            Collections.sort(toSort, lexi);

            for (int i = 0; i < toSort.get(0).size(); i++){
                System.out.print(toSort.get(0).get(i)+" ");
            }
            System.out.println();

            n = input.nextInt();
        }
    }
}
