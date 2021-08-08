public class Merge {

     private static Comparable aux[];

     private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
          if(Helper.lessthan(a[mid-1], a[mid])){
               for(int i = lo; i<=hi;i++)    aux[i] = a[i];
               return;
          }
          int p1 = lo,p2 = mid;
          for(int i = lo; i<=hi; i++){
               if(p1>=mid)   aux[i] = a[p2++];
               else if(p2>hi)      aux[i] = a[p1++];
               else if(Helper.lessthan(a[p1], a[p2]))  aux[i] = a[p1++];
               else aux[i] = a[p2++];
          }
     }

     private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
          if(hi-lo <= 64){
               Insertion.sort(aux,lo,hi);
               return;
          }
          int mid = lo + ((hi-lo)/2);
          sort(aux,a,lo,mid);
          sort(aux,a,mid+1,hi);
          merge(a,aux,lo,mid+1,hi);
     }


     public static void sort(Comparable[] a){
          aux = new Comparable[a.length];
          for(int i = 0; i<a.length; i++){
               aux[i] = a[i];
          }
          sort(aux,a,0,a.length-1);
     }
}