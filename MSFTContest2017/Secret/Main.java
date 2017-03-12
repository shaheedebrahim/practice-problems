import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        HashMap<String, String> graph = new HashMap<String,String>();

        String[] tokens = line.split(" ");
        for (int i = 0; i < tokens.length; i++){
            String a = tokens[i].split("-")[0];
            String b = tokens[i].split("-")[1];

            if (!graph.containsKey(a)){
                graph.put(a,b);
            }
        }

        String message = input.nextLine();
        String decoded ="";

        for (int i = 0; i < message.length(); i++){
            String a = message.charAt(i)+"";
            boolean upperCase = a.equals(a.toUpperCase());
            a = a.toUpperCase();
            if (graph.containsKey(a)){
                String d = graph.get(a);
                if (!upperCase){
                    decoded+=d.toLowerCase();
                }else{
                    decoded+= d;
                }
            }else{
                decoded+=message.charAt(i);
            }
        }

        System.out.println(decoded);
    }
}
