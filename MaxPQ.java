public class MaxPQ <Key extends Comparable<Key>>{
     private Key[] a;
     private int size;

     public MaxPQ(){
          a = (Key[]) new Comparable[2];
          size = 0;
     }

     public MaxPQ(Key[] a){
          this.a = a;
          size = 0;
          for(int i =0; i < a.length;i++){
               swim(i);
               size++;
          }
     }

     private void swim(int i){
          int parent = (i-1)/2;
          while((i>=0) && (parent >=0)){
               if(lessthan(a[parent], a[i]))    exch(a, parent, i);
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
                    if(lessthan(a[child], a[child+1])) max = child +1;
               }
               if(lessthan(a[i], a[max])){
                    exch(a, max, i);
                    i = max;
                    child = (i*2)+1;
               }else     break;
          }
     }

     public void insert(Key val){
          if(size == a.length)     resize(a.length * 2);
          a[size++] = val;
          swim(size-1);
     }

     public boolean isEmpty(){
          return size == 0;
     }

     public Key delMax(){
          if(isEmpty())  return null;
          Key temp = a[0];
          a[0] = a[--size];
          a[size] = null;
          if(a.length/4 >= size)   resize(a.length/2);
          sink(0);
          return temp;
     }

     public Key max(){
          return a[0];
     }

     public int size(){
          return size;
     }

     private void resize(int capacity){
          Key[] b = (Key[]) new Comparable[capacity];
          for(int i = 0; i<size; i++){
               b[i] = a[i];
          }
          a = b;
     }

     private boolean lessthan(Key i, Key j){
          return i.compareTo(j) < 0;
     }

     private void exch(Key[] a, int i,int j){
          Key temp = a[i];
          a[i] = a[j];
          a[j] = temp;
     }

     public static void main(String[] args) {
          MaxPQ<Integer> pq = new MaxPQ<Integer>();
          pq.insert(1);
     }
}