import java.security.DrbgParameters.Capability;

public class Heap{
     private Comparable[] a;
     private int size;

     public Heap(){
          a = new Comparable[2];
          size = 0;
     }

     public Heap(int capacity){
          a = new Comparable[capacity];
          size = 0;
     }

     public Heap(Comparable[] a){
          this.a = a; 
     }

     private void swim(int i){
          int parent = (i-1)/2;
          while((i>=0) && (parent >=0)){
               if(Helper.lessthan(a[parent], a[i]))    Helper.exch(a, parent, i);
               else break;
               i = parent;
               parent = (i-1)/2;
          }
     }

     private void sink(int i){
          int child = (i*2)+1;
          while(i < size && child  < size){
               int max = child;
               if(child+1 < size){
                    if(Helper.greaterthan(a[child+1], a[child])) max = child +1;
               }
               if(Helper.greaterthan(a[max], a[i])){
                    Helper.exch(a, max, i);
                    i = max;
                    child = (i*2)+1;
               }else     break;
          }
     }

     public void put(Comparable val){
          if(size == a.length)     resize(a.length * 2);
          a[size++] = val;
          swim(size-1);
     }

     public boolean isEmpty(){
          return size == 0;
     }

     public Comparable getMax(){
          if(isEmpty())  return null;
          Comparable temp = a[0];
          a[0] = a[--size];
          a[size] = null;
          if(a.length/4 >= size)   resize(a.length/2);
          sink(0);
          return temp;
     }

     public Comparable viewMax(){
          return a[0];
     }

     public int size(){
          return size;
     }

     private void resize(int capacity){
          Comparable[] b = new Comparable[capacity];
          for(int i = 0; i<size; i++){
               b[i] = a[i];
          }
          a = b;
     }

     public static void sort(Comparable[] arr){
          Heap h = new Heap(arr);
          for(int i =0; i < arr.length;i++){
               h.swim(i);
               h.size++;
          }
          for(int i = 0;i < arr.length;i++){
               Helper.exch(h.a, 0, --h.size);
               h.sink(0);
          }
     }

     public static void main(String args[]){
          
     }
}