public class Quick{

     public static void sort(Comparable[] a){
          CustomRandom.shuffle(a);
          sort(a,0,a.length-1);
     }

     // sort methods
     private static int partition(Comparable[] a, int lo, int hi){
          Helper.exch(a, Helper.median3(a, lo, hi), lo);
          int i = lo, j = hi+1;
          while(true){
               while(Helper.lessthan(a[++i],a[lo]))
                    if(i == hi) break;
               while(Helper.lessthan(a[lo], a[--j]))
                    if(j==lo) break;

               if(i>=j) break;
               Helper.exch(a, i, j);
          }
          Helper.exch(a, lo, j);
          return j;
     }

     private static void sort(Comparable[] a,int lo, int hi){
          if(hi-lo <= 64){
               Insertion.sort(a,lo,hi);
               return;
          }
          int p = partition(a, lo, hi);
          sort(a,lo,p-1);
          sort(a,p+1,hi);
     }

     private static void sort3(Comparable[] a,int lo,int hi){
          if(hi<=lo) return;
          Helper.exch(a, Helper.median3(a, lo, hi), lo);
          int lt = lo, gt = hi;
          Comparable v = a[lo];
          int i = lo+1;
          while(i <= gt){
               if      (Helper.lessthan(a[i], v)) Helper.exch(a, lt++, i++);
               else if (Helper.greaterthan(a[i], v)) Helper.exch(a, i, gt--);
               else              i++;
          }
          
          sort3(a,lo,lt-1);
          sort3(a,gt+1,hi);
     }

     private static void select(Comparable[] a, int index, int lo,int hi){
          int p = partition(a, lo, hi);
          if(p==index){
               System.out.println(index+"th smallest is "+ a[p]);
               return;
          }
          if(p>index) select(a,index,lo,p-1);
          if(p<index) select(a, index,p+1,hi);
          return;
     }

     public static void select(Comparable[] a, int index){
          if(index >= a.length) return;
          select(a, index-1,0,a.length-1);
     }
}