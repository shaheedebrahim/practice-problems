import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        HashMap<String, String> parents = new HashMap<String, String>();

        //Adding bidirectional for the cities is why this part is so long
        for (int i = 0; i < n; i++){
            String line = input.nextLine();
            String[] split = line.split(" ");

            ArrayList<String> list;
            if (graph.containsKey(split[0])){
                list = graph.get(split[0]);
            }else{
                list = new ArrayList<String>();
            }

            for (int j = 1; j < split.length; j++){
                if (list.indexOf(split[j]) == -1){
                    list.add(split[j]);
                    ArrayList<String> valueList;
                    if (graph.containsKey(split[j])){
                        valueList = graph.get(split[j]);
                    }else{
                        valueList = new ArrayList<String>();
                    }

                    if (valueList.indexOf(split[0]) == -1) valueList.add(split[0]);
                    graph.put(split[j], valueList);
                }
            }
            graph.put(split[0], list);
        }

        Iterator<String> iter = graph.keySet().iterator();
        while (iter.hasNext()){
            parents.put(iter.next(), "");
        }

        String line = input.nextLine();
        parents = bfs(line.split(" ")[0], line.split(" ")[1], parents, graph);

        if (parents == null){
            System.out.println("no route found");
        }else{
            ArrayList<String> path = new ArrayList<String>();
            String parent = line.split(" ")[1];
            while (!parent.equals("")){
                path.add(parent);
                parent = parents.get(parent);
            }
            Collections.reverse(path);
            for (String s : path){
                System.out.print(s +" ");
            }
        }

    }

    public static HashMap<String, String> bfs (String start, String end, HashMap<String, String> p, HashMap<String, ArrayList<String>> graph){
        Queue<String> q = new LinkedList<String>();
        HashSet visited = new HashSet<String>();

        HashMap<String, String> parents = p;

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()){
            String current = q.poll();
            if (current.equals(end)) return parents;
            
            ArrayList<String> neighbors = graph.get(current);

            if (neighbors != null){
                for (String neighbor : neighbors){
                    if (!visited.contains(neighbor)){
                        visited.add(neighbor);
                        parents.put(neighbor, current);
                        q.add(neighbor);
                    }
                }
            }
        }
        return null;
    }
}
