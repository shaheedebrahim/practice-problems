import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        while (input.hasNextLine()){
            String[] arg = input.nextLine().split(" ");
            if (arg[0].equals("define")){
                dict.put(arg[2], Integer.parseInt(arg[1]));
            }else{
                switch(arg[2]){
                    case "<":
                        if (!(dict.containsKey(arg[1]) && dict.containsKey(arg[3]))) System.out.println("undefined");
                        else if (dict.get(arg[1]).intValue() < dict.get(arg[3]).intValue()) System.out.println("true");
                        else System.out.println("false");
                        break;
                    case ">":
                        if (!(dict.containsKey(arg[1]) && dict.containsKey(arg[3]))) System.out.println("undefined");
                        else if (dict.get(arg[1]).intValue() > dict.get(arg[3]).intValue()) System.out.println("true");
                        else System.out.println("false");
                        break;
                    case "=":
                        if (!(dict.containsKey(arg[1]) && dict.containsKey(arg[3]))) System.out.println("undefined");
                        else if (dict.get(arg[1]).equals(dict.get(arg[3]))) System.out.println("true");
                        else System.out.println("false");
                        break;
                }
            }
        }
    }
}

