public class Jump{
     
     public static int min(Integer i,int j){
          if(i<j) return i;
          else return j;
     }

     public static void main(String args[]){
          int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
          int l = 11;
          boolean[] marked = new boolean[l];
          int[] distance = new int[l];
          int[] edgeTo = new int[l];
          for(int i = 0; i<l;i++){
               marked[i] = false;
               distance[i] = -1;
               edgeTo[i] = -1;
          }

          Queue<Integer> q = new Queue<Integer>();
          int v = 0;
          q.enqueue(v);
          marked[v] = true;
          distance[v] = 0;
          while(!q.isEmpty()){
               v = q.dequeue();
               for(int i = v; i< min(v + a[v] ,l); i++){
                    if(!marked[i]){
                         q.enqueue(i);
                         marked[i] = true;
                         distance[i] = distance[v] + 1;
                         edgeTo[i] = v;
                    }
               }
          }
          for(int i = 0; i<l;i++)
               System.out.println("dis "+i+" : "+marked[i]);
     }
}