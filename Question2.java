import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
class FirstNonRepeatingStream{
    public Map<Character, Integer> hashMap;
    public FirstNonRepeatingStream(){
         hashMap = new HashMap<>();
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
    public char getFirstNonRepeating(){
         TreeMap<Character, Integer> sortedMap = new TreeMap<>(hashMap);
        Character firstKey = sortedMap.firstKey();
        int firstValue = sortedMap.get(firstKey);
        if(firstValue==1){
            return firstKey;
        }
         else{
        return '-';
         }
    }
}

public class Question2 {
    public static void main(String[] args){
      
      FirstNonRepeatingStream s= new FirstNonRepeatingStream();
      s.add('b');
      s.add('k');
      s.add('k');
      s.add('b');
      System.out.println("Non Repeating element: "+ s.getFirstNonRepeating());
    }
}
