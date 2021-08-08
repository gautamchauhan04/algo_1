public class Index {
     public static void main(String[] args) {
          Stopwatch s = new Stopwatch();
          int v = 10;
          int e = 6;
          Graph g = new Graph(v);
          for(int i = 0;i<e;i++){
               int j, k;
               do{
                    j = CustomRandom.randomInt(0, v);
                    k = CustomRandom.randomInt(0, v);
               }while(j == k);
               g.addEdge(j, k);
          }
          for(int i = 0;i<v;i++){
               Sysout.print("adj("+i+")");
               Sysout.print(g.adj(i));
          }
          Sysout.println("#edges: "+g.E());
          ConnectedComponents p = new ConnectedComponents(g);
          Sysout.println(s.elapsedTime());
          /*for(int j: g.adj(2)){
               System.out.println(j);
          }*/

          Sysout.println(p.count());


     }
}