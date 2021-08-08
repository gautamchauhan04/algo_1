public class ConnectedComponents {
     
     private boolean[] marked;
     private int[] edgeTo;
     private int count;

     public ConnectedComponents(Graph G){
          marked = new boolean[G.V()];
          edgeTo = new int[G.V()];
          count = 0;
          for(int i = 0; i<G.V(); i++){
               marked[i] = false;
               edgeTo[i] = -1;
          }
          for(int i = 0; i<G.V();i++){
               if(!marked[i]){
                    dfs(G,i);
                    count++;
               }
          }
     }

     private void dfs(Graph G,int v){
          if(marked[v]) return;
          marked[v] = true;
          for(int a: G.adj(v)){
               dfs(G,a);
               edgeTo[a] = v;
          }
     }

     public int count(){
          return count;
     }     
}