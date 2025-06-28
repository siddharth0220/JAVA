import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        
        // ex County(KEY),Population
        HashMap<String, Float> map = new HashMap<>();
        
        // Insertion of Key value pairs
        map.put("India", 120.00f);
        map.put("Usa", 10000.00f);
        System.out.println(map);
        
        // Search of an element
        if (map.containsKey("India")) {
            System.out.println("Country is Present");
        } else {
            System.out.println("Country is not Present");
        }
        System.out.println(map.get("Usa"));
        
        // iteration in array using hash map
        for (Map.Entry<String, Float> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        
            // to remove an element in hash map we just give the value of key
            map.remove("Usa");
            System.out.println(map);
        }
    }
}
