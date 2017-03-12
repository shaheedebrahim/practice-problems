import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        String[] vowels = new String[]{"a","e","i","o","u","y"};

        String[] line = input.nextLine().split(" ");

        ArrayList<String> fixed = new ArrayList<String>();

        for (String word : line){
            boolean check = false;
            for (String c : vowels){
                if(word.charAt(0).equals(c)) check = true;
            }

            if (check){
                fixed.add(word+"yay");
            }else{
                int index = -1;
                String temp = "";
                for (int i = 0; i < word.length(); i++){
                    boolean check = false;
                    for (String c : vowels){
                        if (word.charAt(i).equals(c)){ 
                            index = i;
                            check = true;
                        }
                    }
                    if (check) break;
                }
                fixed.add(word.substring(index,word.length)+temp+"ay");
            }
        }
        for (int i = 0; i < fixed.size(); i++){
            if (fixed.size() - i = 1){
                System.out.print(fixed.get(i));
            }else{
                System.out.print(fixed.get(i)+" ");
            }
        }
    }
}
