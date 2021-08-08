import java.util.Iterator;

public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key>
{
     private Node root;

     class Node
     {
          private Key key;
          private Value value;
          private Node left = null;
          private Node right = null;
          private int count;
          public Node(Key key, Value value,int count){
               this.key = key;
               this.value = value;
               this.count = count;
          }
     }

     public Value get(Key key)
     {
          Node point = root;
          while(point != null){
               int cmp = key.compareTo(point.key);
               if(cmp == 0) return point.value;
               else if(cmp > 0)    point = point.right;
               else if(cmp < 0)    point = point.left;
          }
          return null;
     }

     public void put(Key key, Value value)
     {
          root = put(root,key,value);
     }

     private Node put(Node point, Key key, Value value)
     {
          if(point == null) return new Node(key,value,1);
          
          int cmp = key.compareTo(point.key);
          if(cmp < 0)
               point.left = put(point.left,key,value);
          else if(cmp > 0)
               point.right = put(point.right,key,value);
          else
               point.value = value;
          point.count = 1 + size(point.left) + size(point.right);
          return point;
     }

     public Key min()
     {
          Node point = root;
          Node parent = root;
          while(point != null){
               parent = point;
               point = point.left;
          }
          return parent.key;
     }

     public Key max()
     {
          Node point = root;
          Node parent = root;
          while(point != null){
               parent = point;
               point = point.right;
          }
          return parent.key;
     }

     public int size(){
          return size(root);
     }

     private int size(Node point){
          if(point == null) return 0;
          return point.count;
     }

     public int weight(){
          return size(root.left) - size(root.right);
     }

     public Key floor(Key key){
          Node point = root;
          Key possibleKey = null;
          while(point != null){
               int cmp = key.compareTo(point.key);
               if(cmp == 0) return point.key;
               else if(cmp > 0){
                    possibleKey = point.key;
                    point = point.right;
               }
               else if(cmp < 0)    point = point.left;
          }
          return possibleKey;
     }

     public Key ceiling(Key key){
          Node point = root;
          Key possibleKey = null;
          while(point != null){
               int cmp = key.compareTo(point.key);
               if(cmp == 0) return point.key;
               else if(cmp > 0)    point = point.right;
               else if(cmp < 0){   
                    possibleKey = point.key; 
                    point = point.left;
               }
          }
          return possibleKey;
     }

     public int rank(Key key){
          Node point = root;
          int rank = 0;
          while(point != null){
               int cmp = key.compareTo(point.key);
               if( cmp == 0 ) return rank+size(point.left);
               else if( cmp < 0) point = point.left;
               else{
                    rank = rank + size(point.left)+ 1;
                    point = point.right;
               }
          }
          return rank;
     }

     public void delete(Key key){
          root = delete(root,key);
     }
     public Node delete(Node point,Key key){
          if(point == null)   return null;
          int cmp = key.compareTo(point.key);
          if( cmp < 0 )  point.left = delete(point.left, key);
          else if(cmp > 0)    point.right = delete(point.right,key);
          else{
               if(point.right == null) return point.left;
               if(point.left == null)   return point.right;

               if(size(point.right) >= size(point.left)){
                    Node t = point;
                    point.right = deleteMin(t.right);
                    point.left = t.left;
               }else{
                    Node t = point;
                    point.left = deleteMax(t.left);
                    point.right = t.right;
               }
          }

          point.count = size(point.right) + size(point.left) + 1;
          return point;
     }

     public void deleteMin(){
          deleteMin(root);
     }

     private Node deleteMin(Node point){
          if(point.left == null) return point.right;
          point.left = deleteMin(point.left);
          point.count = 1 + size(point.right) + size(point.left);
          return point;
     }

     public void deleteMax(){
          deleteMax(root);
     }

     private Node deleteMax(Node point){
          if(point.right == null) return point.left;
          point.right = deleteMin(point.right);
          point.count = 1 + size(point.right) + size(point.left);
          return point;
     }


     public Iterator<Key> iterator() {
          return new bstIterator();
     }

     public class bstIterator implements Iterator<Key>{
          private Stack<Node> s;

          private boolean lstOpPop;

          public bstIterator(){
               s = new Stack<Node>(root);
               lstOpPop = false;
          }

          @Override
          public boolean hasNext() {
               return !s.isEmpty();
          }

          @Override
          public Key next() {
               Node current = s.view();
               while(current != null && !lstOpPop){
                    if(current.left == null) break;
                    s.push(current.left);
                    lstOpPop = false;
                    current = current.left;
               }
               current = s.pop();
               lstOpPop = true;
               if(current.right != null){
                    s.push(current.right);
                    lstOpPop = false;
               }
               return current.key;
          }
     }
}