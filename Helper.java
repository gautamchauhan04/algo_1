public class Helper {
     // helper methods

     // lessthan:
     //        true: a < b
     //        false: a >= b
     public static boolean lessthan(Comparable a,Comparable b){
          return a.compareTo(b) < 0;
     }

     public static boolean greaterthan(Comparable a,Comparable b){
          return a.compareTo(b) > 0;
     }

     public static boolean equal(Comparable a,Comparable b){
          return a.compareTo(b) == 0;
     }

     public static boolean inBetween(Comparable value,Comparable lower,Comparable upper){
          return lessthan(lower, value) && lessthan(value, upper);
     }

     //exch: swap values of two var
     public static void exch(Comparable[] a, int i, int j){
          Comparable temp = a[i];
          a[i] = a[j];
          a[j] = temp;
     }

     public static int max(int i,int j){
          if(i<j) return j;
          else return i;
     }

     public static int median3(Comparable[] a, int lo, int hi){
          int mid;
          mid = lo + (hi - lo) -1;
          if((lessthan(a[lo],a[mid]) && lessthan(a[mid],a[hi])) || (lessthan(a[hi],a[mid]) && lessthan(a[mid],a[lo]))) return mid;
          if((lessthan(a[mid],a[lo]) && lessthan(a[lo],a[hi])) || (lessthan(a[hi],a[lo]) && lessthan(a[lo],a[mid]))) return lo;
          return hi;
     }

     public static boolean isSorted(Comparable[] a,int lo, int hi){
          for(int i = lo;i<hi;i++){
               if(lessthan(a[i+1], a[i])) return false;
          }
          return true;
     }

     public static boolean isSorted(Comparable[] a){
          return isSorted(a,0,a.length-1);
     }


     public static void show(Comparable[] a,int lo, int hi){
          for(int i=lo;i<= hi;i++)
               System.out.print(a[i]+", ");
          System.out.println();
     }

     public static void show(Comparable[] a){
          show(a,0,a.length-1);
     }
}