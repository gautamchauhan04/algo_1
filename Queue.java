import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{
     
     private class Node{
          Item value;
          Node next; 
     }

     private Node head,tail;
     private int size;

     public Queue(){
          head = null;
          tail = null;
          size = 0;
     }
     
     public boolean isEmpty(){
          return head == null;
     }

     public Item peek(){
          if(isEmpty()) throw new NoSuchElementException();
          return head.value;
     }

     public void enqueue(Item value){
          if(value == null)
               throw new NullPointerException("null is not allowed");
          Node oldtail = tail;
          tail = new Node();
          tail.value = value;
          if(isEmpty()) head = tail;
          else oldtail.next = tail;
          size++;
     }    

     public Item dequeue(){
          if(isEmpty()) 
               throw new NoSuchElementException("Queue is empty.");
          Item value = head.value;
          head = head.next;
          if(isEmpty())  tail = null;
          return value;
     }

     public int size(){
          return size;
     }

	@Override
	public Iterator<Item> iterator() {
		return new queueIterator();
     }
     
     private class queueIterator implements Iterator<Item>{
          private Node current = head;

          public boolean hasNext(){
               return current != null;
          }

          public Item next(){
               if(!hasNext()) throw new NoSuchElementException(); 
               Item value = current.value;
               current = current.next;
               return value;
          }
     }
}