import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
class FirstNonRepeatingStream{
    public Map<Character, Integer> hashMap;
    public LinkedHashMap<Character, Integer> sortedHashMap;

    public FirstNonRepeatingStream(){
         hashMap = new HashMap<>();
         sortedHashMap = new LinkedHashMap<>();
       
    }
    public void add(char c){
        int count=1;
        if(hashMap.containsKey(c)){
            int a=hashMap.get(c);
            count=count+a;
            hashMap.put(c, count);
          }
          else{
              hashMap.put(c, count);
         }

    }
    public void sortMap(){

      List<Map.Entry<Character, Integer>> entries = new ArrayList<>(hashMap.entrySet());

        entries.sort(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Character, Integer> entry : entries) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
    }
    
    public char getFirstNonRepeating(){
         
        Character firstKey =  sortedHashMap.keySet().iterator().next();
        int firstValue =  sortedHashMap.get(firstKey);

        if (firstValue == 1) {
            return firstKey;
        } else {
            return '-';
        }
    }
    public void Display(){
        System.out.println("Stream: ");
        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()) {
                    int count= entry.getValue();
                    while(count!=0){
                    System.out.print(entry.getKey()+" ");
                    count--;
                    }
            }
    }
}

public class Question2 {
    public static void main(String[] args){
      
      FirstNonRepeatingStream s= new FirstNonRepeatingStream();
      s.add('a');
      s.add('b');
      s.add('b');
     // s.add('b');
      s.sortMap();
      s.Display();

      System.out.println("\nFirst Non Repeating element: "+ s.getFirstNonRepeating());

      
    }
}