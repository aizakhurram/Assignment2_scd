import java.util.ArrayList;

public class Question3 {
     public static void mergeList(ArrayList<int[]> list){
        if (list == null) {
            return;
        }
        for(int i=1, y=0; i<list.size(); i++){
            int[] interval= list.get(y);
            int[] next=list.get(i);
            if(interval[interval.length-1]>=next[0]){
                interval[interval.length-1]=Math.max(next[next.length-1],interval[interval.length-1]);
            
            }
            else{
            y++;
            list.set(y, next);
           
        }
        }
        for(int i=0, y=1; i<list.size(); i++,  y++){
            if(y>=list.size()){
                break;
            }
            
            if(list.get(i)==list.get(y) && i!=y){
                list.remove(y);
                
               
            }
          
        
        }
       
      }
      public static void Display(ArrayList<int[]> list){
        for (int[] interval : list) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
      }
      
    public static void main(String[] args){
        ArrayList<int[]> list= new ArrayList<>();
        list.add(new int[]{1, 7});
        list.add(new int[]{2, 8});
        list.add(new int[]{8, 10});
        list.add(new int[]{15, 18});

        mergeList(list);
        Display(list);


    }
}
