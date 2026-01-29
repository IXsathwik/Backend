import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class problem2 {

    public static void main(String[] args) {
        
        String[] names = {"Alice", "Bob", "Charlie","David", "Eve", "Frank","Acile", "Bob", "Charlie"};
        
        System.out.println("Original-names::");
        for (String name : names) {
            System.out.println(name);
        }

        ArrayList<String> emp = new ArrayList<>();

        for (String name : names) {
            emp.add(name);
        }

        HashSet<String> empSet = new HashSet<>(emp);

        for (String item : emp) {
            empSet.add(item);
        }

        HashMap<String, Integer> empMap = new HashMap<>();

        for (String item : emp) {  
            empMap.put(item, empMap.getOrDefault(item, 0) + 1);
 
        }



        System.out.println("\nArrayList Data:");
        for (String e : emp) {
            System.out.println(e);
        }



       
        System.out.println("\nHashSet Data (using Iterator):");
        Iterator<String> setIterator = empSet.iterator();
        while (setIterator.hasNext()) {
            System.out.println(setIterator.next());
        }



        System.out.println("\nHashMap Data (Name : Frequency):");
        Iterator<Map.Entry<String, Integer>> mapIterator = empMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Integer> entry = mapIterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }











    }
    
}
