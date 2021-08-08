public class Bipartite {
     
     private boolean[] marked;
     private int[] side;
     private boolean isBipartite;

     public Bipartite(Graph G){
          marked = new boolean[G.V()];
          side = new int[G.V()];
          for(int i = 0;i < G.V(); i++){
               marked[i] = false;
               side[i] = -1;
          }
          isBipartite = false;
          check(G);
     }

     private void check(Graph G){
          Queue<Integer> q =  new Queue<Integer>();
          for(int v = 0; v<G.V();v++){
               if(!marked[v]){
                    side[v] = 0;
                    q.enqueue(v);
                    while(!q.isEmpty()){
                         v = q.dequeue();
                         marked[v] = true;
                         for(int j: G.adj(v)){
                              if(!marked[j])
                                   q.enqueue(j);
                         }
                         if(!validAdj(G, v)){
                              isBipartite = false;
                              return;
                         }
                         mark(G, v);
                    }
               }
          }
          isBipartite = true;
     }

     public boolean isBipartite(){
          return isBipartite;
     }

     private boolean validAdj(Graph G,int v){
          for (int j: G.adj(v)){
               if(marked[j] && (side[v] == side[j])){
                    return false;
               }
          }
          return true;
     }

     private void mark(Graph G, int v){
          int t = 0;
          if(side[v] == 0) t = 1;
          for(int j: G.adj(v)){
               if(!marked[j]){
                    side[j] = t;
               }
          }
     }

     public static void main(String[] args) {
          Graph g = new Graph(9);
          g.addEdge(0, 5);
          //g.addEdge(0, 6);
          g.addEdge(1, 2);
          g.addEdge(1, 3);
          g.addEdge(4, 2);
          g.addEdge(4, 3);
          g.addEdge(4, 5);
          //g.addEdge(4, 6);
          g.addEdge(6, 7);
          g.addEdge(8, 7);
          g.addEdge(6, 8);
          Bipartite b = new Bipartite(g);
          Sysout.print(b.isBipartite());
     }

}