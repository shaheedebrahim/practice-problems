import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<String>();

        while (input.hasNextLine()){
            names.add(input.nextLine());
        }

        //First sort by last names and if last names are equal sort by first names
        Comparator<String> sort = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String lastName1 = o1.split(" ")[1];
                String lastName2 = o2.split(" ")[1];

                int result = lastName1.compareTo(lastName2);
                if (result != 0){
                    return result; 
                }else{
                    return o1.split(" ")[0].compareTo(o2.split(" ")[0]);
                }
            }
        };
        
        Collections.sort(names, sort);

        //Now mark all the people who have the same first names
        boolean[] checked = new boolean[names.size()];
        for (int i = 0; i < names.size(); i++){
            String firstName1 = names.get(i).split(" ")[0];
            //If we have already checked someone we don't have to loop n times again (small optimization)
            if (!checked[i]){
                for (int j = 0; j < names.size(); j++){
                    String firstName2 = names.get(j).split(" ")[0];
                    if (i != j && firstName1.equals(firstName2)){
                        checked[i] = true;
                        checked[j] = true;
                    }
                }
            }
        }

        //Remove all the last names from those who do not have duplicate first names
        for (int i = 0; i < checked.length; i++){
            if (!checked[i]){
                names.set(i, names.get(i).split(" ")[0]);
            }
        }

        for (String name : names){
            System.out.println(name);
        }


    }
}
