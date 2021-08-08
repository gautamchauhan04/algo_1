import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {

     private Item[] a;
     private int size;

     public Bag(int capacity) {
          a = (Item[]) new Object[capacity];
          size = 0;
     }

     public Bag() {
          this(2);
     }

     public boolean isEmpty(){
          return size == 0;
     }

     public int size(){
          return size;
     }

     public void add(Item item){
          if(item == null) throw new NullPointerException("Null value is alowed.");
          if(size==a.length)  resize(a.length * 2);
          a[size++] = item;
     }

     private void resize(int capacity){
          Item[] b = (Item[]) new Object[capacity];
          for(int i = 0; i<size; i++){
               b[i] = a[i]; 
          }
          a= b;
     }

     @Override
     public Iterator<Item> iterator() {
          return new bagIterator();
     }

     private class bagIterator implements Iterator<Item>{

          private int i;

          @Override
          public boolean hasNext() {
               return i<size;
          }

          @Override
          public Item next() {
               if(i == size) throw new NoSuchElementException();
               return a[i++];
          }

     }
     
}