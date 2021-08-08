import java.util.Random;

public class CustomRandom{

     public static int randomInt(int lowerRange,int upperRange){
          Random random = new Random();
          return lowerRange + random.nextInt(upperRange - lowerRange);
     }

     // shuffle 
     public static void shuffle(Comparable[] a){
          int len = a.length;
          for(int i = 0; i< len;i++){
               int pos = randomInt(0, i+1);
               Helper.exch(a,pos,i);
          }
     }

     public static int[] genRandomIntArray(int len, int lowerRange, int upperRange){
          int[] a = new int[len];
          for(int i = 0;i<len;i++){
               a[i] = randomInt(lowerRange,upperRange);
          }
          return a;
     }

     public static Integer[] genRandomIntegerArray(int len, int lowerRange, int upperRange){
          Integer[] a = new Integer[len];
          for(int i = 0;i<len;i++){
               a[i] = randomInt(lowerRange,upperRange);
          }
          return a;
     }

     public static String genRandomString(int len,boolean caseSensitive){
          if(caseSensitive)   return genCaseSensRandomString(len);
          String s = "";
          for(int i = 0; i<len;i++){
               int rand = randomInt(97,122);
               char c = (char) rand;
               s = s+c;
          }
          return s;
     }
     private static String genCaseSensRandomString(int len){
          String s = "";
          for(int i = 0; i<len;i++){
               int rand = randomInt(65,116);
               if(rand >=91)     rand = rand + 6;
               char c = (char) rand;
               s = s+c;
          }
          return s;
     }

     public static String[] genRandomStringArray(int arrayLenght, int stringLengthMin, int stringLengthMax,boolean caseSensitive){
          String[] a = new String[arrayLenght];
          for(int i = 0;i<arrayLenght;i++){
               int strLen = randomInt(stringLengthMin, stringLengthMax);
               a[i] = genRandomString(strLen, caseSensitive);
          }
          return a;
     }
     
}