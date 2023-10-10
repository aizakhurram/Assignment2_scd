import java.util.ArrayList;
public class Question3 {
     public static void mergeList(ArrayList<int[]> list){
        if (list == null) {
            return;
        }
        int y=0;
        for(int i=1; i<list.size(); i++){
            int[] current= list.get(y);
            int[] next=list.get(i);
            if(current[current.length-1]>=next[0]){
                current[current.length-1]=Math.max(next[next.length-1],current[current.length-1]);
            }
            else{
            y++;
            list.set(y, next);
           
        }
        }
        int i = 1;
       while (i < list.size()) {
         if (list.get(i - 1)[1] >= list.get(i)[0]) {
          list.remove(i);
          } else {
          i++;
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
        list.add(new int[]{2, 6});
        list.add(new int[]{8, 10});
        list.add(new int[]{15, 18});

        mergeList(list);
        Display(list);


    }
}
