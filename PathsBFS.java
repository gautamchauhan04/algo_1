public class PathsBFS {
     
     private boolean[] marked;
     private int[] distance;
     private int[] edgeTo;
     private int s;

     public PathsBFS(Graph G, int s){
          marked = new boolean[G.V()];
          distance = new int[G.V()];
          edgeTo = new int[G.V()];
          for(int i = 0; i<G.V();i++){
               marked[i] = false;
               distance[i] = -1;
               edgeTo[i] = -1;
          }
          this.s = s;
          bfs(G,s);
     }

     private void bfs(Graph G, int v){
          Queue<Integer> q = new Queue<Integer>();
          q.enqueue(v);
          marked[v] = true;
          distance[v] = 0;
          while(!q.isEmpty()){
               v = q.dequeue();
               for(int i: G.adj(v)){
                    if(!marked[i]){
                         q.enqueue(i);
                         marked[i] = true;
                         distance[i] = distance[v] + 1;
                         edgeTo[i] = v;
                    }
               }
          }
     }

     public boolean hasPathTo(int v){
          return marked[v];
     }

     public Iterable<Integer> pathTo(int v){
          if(!hasPathTo(v))   return null;
          Stack<Integer> st = new Stack<Integer>();
          while(v != s){
               st.push(v);
               v = edgeTo[v];
          }
          st.push(v);
          return st;
     }

     public int distanceTo(int v){
          return distance[v];
     }
}