import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while (n!=0){
            int m = input.nextInt();
            int q = input.nextInt();
            int s = input.nextInt();

            HashMap<Integer, ArrayList<Node>> map = new HashMap<Integer, ArrayList<Node>>();
            for (int i = 0; i < m; i++){
                int u = input.nextInt();
                int v = input.nextInt();
                int w = input.nextInt();

                if (map.containsKey(u)){
                    ArrayList<Node> temp = map.get(u);
                    Node tempNode = new Node(v, w);
                    temp.add(tempNode);
                    map.put(u, temp);
                }else{
                    ArrayList<Node> newList = new ArrayList<Node>();
                    newList.add(new Node(v, w));
                    map.put(u, newList);
                }
            }

            long dist[] = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE - 2001);
            dist[s] = 0;

            for (int i = 0; i < n-1; i++){
                for (int u = 0; u < n; u++){
                    if (map.get(u) != null){
                        for (int j = 0; j < map.get(u).size(); j++){
                            Node v = map.get(u).get(j);
                            dist[v.v] = Math.min(dist[v.v], dist[u] + v.w);
                        }
                    }
                }
            }

            boolean hasNegCycle = false;
            boolean negCycle[] = new boolean[n];
            for (int u = 0; u < n; u++){
                if (map.get(u) != null){
                    for (int j = 0; j < map.get(u).size(); j++){
                        Node v = map.get(u).get(j);
                        if (dist[v.v] > dist[u] + v.w){
                            negCycle[u] = true;
                        }
                    }
                }
            }

            for (int i = 0; i < q; i++){
                int query = input.nextInt();
                if (dist[query] == Long.MAX_VALUE - 2001){
                    System.out.println("Impossible");
                }else if (negCycle[i]){
                    System.out.println("-Infinity");
                }else{
                    System.out.println(dist[query]);
                }
            }
            System.out.println("");
            n = input.nextInt();
        }
    }

    public static boolean checkNeg(HashMap<Integer, ArrayList<Node>> map, int query, long[] dist){
        if (map.get(query) == null) return false;
        for (int i = 0; i < map.get(query).size(); i++){
            Node temp = map.get(query).get(i);
            if (dist[query] + map.get(query).get(i).w < dist[query]) return true;
        }
        return false;
    }

    public static class Node{
        int v;
        int w;
        public Node(int vert, int weight){
            v = vert;
            w = weight;
        }
    }
}
