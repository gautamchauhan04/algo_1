import java.util.Iterator;

public class Sysout {

     public static void println(){
          System.out.println();
     }
     
     public static void print(String s){
          System.out.print(s);
     }

     public static void print(String[] s){
          for(int i = 0; i < s.length; i++){
               Sysout.print(s);
               if(i <(s.length-1))    Sysout.print(", ");
          }
          Sysout.println();
     }

     public static void println(String s){
          System.out.println(s);
     }

     public static void println(String[] s){
          for(int i = 0; i < s.length; i++)
               Sysout.println(s);
          Sysout.println();
     }

     public static void print(int s){
          System.out.print(s);
     }
     public static void print(int[] s){
          for(int i = 0; i < s.length; i++){
               Sysout.print(s);
               if(i <(s.length-1))    Sysout.print(", ");
          }
          Sysout.println();
     }

     public static void println(int s){
          System.out.println(s);
     }
     public static void println(int[] s){
          for(int i = 0; i < s.length; i++)
               Sysout.println(s);
          Sysout.println();
     }

     public static void print(double d){
          System.out.print(d);
     }

     public static void print(double[] s){
          for(int i = 0; i < s.length; i++){
               Sysout.print(s);
               if(i <(s.length-1))    Sysout.print(", ");
          }
          Sysout.println();
     }

     public static void println(double d){
          System.out.println(d);
     }

     public static void println(double[] s){
          for(int i = 0; i < s.length; i++)
               Sysout.println(s);
          Sysout.println();
     }


     public static void print(Boolean d){
          System.out.print(d);
     }

     public static void print(Boolean[] s){
          for(int i = 0; i < s.length; i++){
               Sysout.print(s);
               if(i <(s.length-1))    Sysout.print(", ");
          }
          Sysout.println();
     }

     public static void println(Boolean d){
          System.out.println(d);
     }

     public static void println(Boolean[] s){
          for(int i = 0; i < s.length; i++)
               Sysout.println(s);
          Sysout.println();
     }

     public static void print(Iterable<Integer> i){
          for(int j: i){
               Sysout.print(j);
               Sysout.print(", ");
          }
          Sysout.println();
     }

     public static void println(Iterable<Integer> i){
          for(int j: i){
               Sysout.println(j);
          }
     }
}