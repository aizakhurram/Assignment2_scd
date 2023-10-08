import java.util.Map;
import java.util.HashMap;
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
        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()) {
            if(entry.getValue()==1){
                return entry.getKey();
            }

        }
        return '-';
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
