public class PathsDFS{

     private boolean[] marked;
     private int[] edgeTo;
     private int s;
     
     public PathsDFS(Graph G,int s){
          marked = new boolean[G.V()];
          edgeTo = new int[G.V()];
          for(int i = 0; i<G.V();i++){
               marked[i] = false;
               edgeTo[i] = -1;
          }

          dfs(G,s);
     }

     private void dfs(Graph G,int v){
          if(marked[v]) return;
          marked[v] = true;
          for(int a: G.adj(v)){
               dfs(G,a);
               edgeTo[a] = v;
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
}