import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        
        for (int i = 0; i < n; i++){
            String line[] = input.nextLine().split(" ");
            if (graph.containsKey(line[0])){
                ArrayList<String> temp = graph.get(line[0]);
                temp.add(line[1]);
                graph.put(line[0], temp);
            }else{
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(line[1]);
                graph.put(line[0], temp);
            }
        }

        while (input.hasNext()){
            String start = input.nextLine();
            boolean safe = dfs(graph,start);
            System.out.println(start+" "+ (safe == true ? "safe" : "trapped"));
        }
    }

    public static boolean dfs(HashMap<String, ArrayList<String>> graph, String start){
        Stack<String> s = new Stack<String>();
        HashSet<String> visited = new HashSet<String>();
        HashMap<String, String> pre = new HashMap<String, String>();
        pre.put(start, "");
        s.push(start);

        while (!s.empty()){
            String curr = s.pop();
            visited.add(curr);
            ArrayList<String> temp = graph.get(curr);
            if (temp != null){
                for (String dest : temp){
                    if (visited.contains(dest)){
                        if (checkCycle(curr, dest, start, pre)) return true;
                    }
                    s.push(dest);
                    pre.put(dest, curr);
                }
            }
        }
        return false;
    }

    public static boolean checkCycle(String curr, String cycleString, String start,  HashMap<String, String> pre){
        String m = pre.get(curr);
        while (!m.equals(start)){
            if (m.equals(cycleString)) return true;
            m = pre.get(m);
        }
        return false;
    }
}
