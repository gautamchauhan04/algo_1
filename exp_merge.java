
public class exp_merge {

     public static void merge(Comparable[] a, int mid){
          int i = 0;
          int j = mid;
          Integer o = -1;
          while((val(a,i) != o) || (val(a,j) != o)){
               Helper.show(a);
               System.out.println("i = "+i+" j = "+j);
               while(Helper.lessthan(a[j], a[i])){
                    Helper.exch(a,i,j);
                    if(Helper.lessthan(val(a,i+1), val(a,i)))  Helper.exch(a, i, i++);
                    else i++;
               }    Helper.exch(a,i,j);
               if(Helper.lessthan(a[i], a[j])){
                    if(Helper.lessthan(val(a,j+1), val(a,j)))  Helper.exch(a, j, j++);
                    else j++;
               }
          }
     }

     private static Comparable val(Comparable[] a, int i){
          if(i>=a.length){
               return -1;
          }
          return a[i];
     }
}