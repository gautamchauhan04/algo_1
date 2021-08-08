import java.util.Iterator;

public class RedBlackTree<Key extends Comparable<Key>, Value> implements Iterable<Key>{

     private final boolean red = true;
     private final boolean black = false;
     
     private Node root;

     private class Node{
          private Key key;
          private Value value;
          private Node left, right;
          private boolean color;
          private int count;
          public Node(Key key, Value value, boolean color){
               this.key = key;
               this.value = value;
               this.color = color;
               this.count = 1;
          }
     }

     public RedBlackTree(){
          root = null;
     }

     private Node rotateleft(Node point){
          Node right = point.right;
          point.right = right.left;
          right.left = point;
          right.color = point.color;
          point.color = red;
          return right;
     }

     private Node rotateRight(Node point){
          Node left = point.left;
          point.left = left.right;
          left.right = point;
          left.color = point.color;
          point.color = red;
          return left;
     }

     private void flipColor(Node point){
          point.color = red;
          point.left.color = black;
          point.right.color = black;
     }

     private boolean isRed(Node point){
          if(point == null) return false;
          return point.color;
     }

     public int size(){
          return size(root);
     }

     public Value find(Key key){
          Node point = root;
          while(point != null){
               int cmp = key.compareTo(point.key);
               if( cmp == 0 )      return point.value;
               else if( cmp < 0 )  point = point.left;
               else                point = point.right;
          }
          return null;
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

     private int size(Node point){
          if(point == null) return 0;
          return point.count;
     }

     public void delete(Key key){
          throw new UnsupportedOperationException("Delete is not yet added to this Red Black Tree api.");
     }

     public void insert(Key key, Value value){
          root = insert(root, key, value);
     }

     private Node insert(Node point, Key key, Value value){
          if(point == null) return new Node(key,value,red);

          int cmp = key.compareTo(point.key);
          if(cmp < 0)    point.left = insert(point.left, key, value);
          else if(cmp > 0)    point.right = insert(point.right,key, value);
          else{
               point.value = value;
               return point;
          }
          if(isRed(point.right) && !isRed(point.left))  point = rotateleft(point);
          if(isRed(point.left) && isRed(point.left.left))   point = rotateRight(point);
          if(isRed(point.left) && isRed(point.right))  flipColor(point);
          
          point.count = 1 + size(point.left) + size(point.right);

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