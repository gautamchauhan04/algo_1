import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
     private class stuct {
          private Item value;
          private stuct next;
     }

     private stuct head;
     private int size;

     public Stack() {
          head = null;
     }

     public Stack(Item value) {
          head = new stuct();
          head.value = value;
          head.next = null;
          size++;
     }

     public void push(Item value) {
          if (value == null)
               throw new NullPointerException("null is not allowed");
          stuct oldHead = head;
          head = new stuct();
          head.value = value;
          head.next = oldHead;
          size++;
     }

     public Item pop() {
          if (isEmpty())
               throw new EmptyStackException();
          Item temp = head.value;
          head = head.next;
          return temp;
     }

     public Item view(){
          return head.value;
     }

     public int size() {
          return size;
     }

     public boolean isEmpty() {
          return head == null;
     }

     @Override
     public Iterator<Item> iterator() {
          return new stackIterator();
     }

     private class stackIterator implements Iterator<Item>{

          private stuct current = head;

          @Override
          public boolean hasNext() {
               return current != null;
          }

          @Override
          public Item next() {
               if (isEmpty())      throw new EmptyStackException();
               Item temp = current.value;
               current = current.next;
               return temp;
          }
          
     }

 }