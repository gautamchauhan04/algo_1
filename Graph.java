public class Graph{

     private Bag<Integer>[] adj;
     private int noOfVertices;

     public Graph(int noOfVertices){
          adj = (Bag<Integer>[]) new Bag[noOfVertices];
          this.noOfVertices = noOfVertices;
          for(int v = 0;v<noOfVertices;v++)
               adj[v] = new Bag<Integer>();
     }

     public void addEdge(int vertice1, int vertice2){
          adj[vertice1].add(vertice2);
          adj[vertice2].add(vertice1);
     }

     /*public int[] adj(int vertice){
          int edges = adj[vertice].size();
          int[] temp = new int[edges];
          int j = 0;
          Iterator<Integer> i = adj[vertice].iterator();
          while(i.hasNext())  temp[j++] = i.next();
          return temp;
     }*/

     public Iterable<Integer> adj(int v){
          return adj[v];
     }

     public boolean hasAdj(int v){
          return !adj[v].isEmpty();
     }

     public int V(){
          return noOfVertices;
     }

     public int E(){
          int count = 0;
          for(int v = 0; v< noOfVertices;v++)
               count = count + adj[v].size();
          return count/2;
     }
     
}