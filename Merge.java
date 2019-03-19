import java.util.*;
import java.lang.*;
public class Merge{
  public static int[] merge(int[] M, int[] N){
    //make the storage array;
    int[] ans = new int[M.length + N.length];
    //make sure both arrays are in bound
    int m = 0;
    int n = 0;
    int mRemaining = M.length;
    int nRemaining = N.length;
    //loop through both arrays using "paper top method"
    while(m < M.length && n < N.length){
      //Starting at 0, look at smalles of both
      if(M[m] > N[n]){
        //if ns smallest is smaller, add 1 to "N" and set the index to m
        ans[n + m] = N[n];
        n++;
        nRemaining--;
      //  System.out.println("n " + n);
      } else {
        ans[n + m] = M[m];
        m++;
        mRemaining--;
      //  System.out.println("m " + m);
      }
    }
      //System.out.println("out of the loop");

    //Now we still have the rest of the maximum array leftOver
    //find the maximum array, lets call it bigger
    //atleast one of these will be 0
    //System.out.println(mRemaining);
    //System.out.println(nRemaining);
    int bi = Math.max(mRemaining, nRemaining);

    //System.out.println(bi);
    if(bi == mRemaining){
      //if m remaining has stuff left, add it to the end of the answer
      for(int i = m; i < M.length; i++ ){
        ans[i + N.length] = M[i];
      }
    } else {

      for(int i = n; i < N.length; i++){
        ans[i + M.length] = N[i];
        //System.out.println(ans[i]);
      }
    }

    return ans;
    //Take the rest of the bigger array and just add it to the end of the answer array


    }


    //
    public static void mergeSort(int[] list){
      list = mergeH(0,list.length - 1, list);
    }


    public static int[] mergeH(int lo, int hi, int[] list){
      System.out.println("lo: " + lo);
      System.out.println("hi: " + hi);
      //ok, we want to split up the list into much smaller lists
      //we can start off by saying that if the list has length 1 or lo = hi, were gonna
      //return a list with only that element
      if(lo == hi){
        int[] ans = new int[1];
        ans[0] = list[lo];
        return ans;
      }
      //now we can mergeH the smaller cases
      int[] h1 = mergeH(lo, (lo + hi)/2, list);
      int[] h2 = mergeH((lo + hi)/2 + 1, hi, list);
      System.out.println(Arrays.toString(merge(h1, h2)));
      return merge(h1, h2);
    }

    public static String print(int[] M){
      String ans = "";
      for(int i = 0; i < M.length; i++){
        ans += M[i] + " ";
      }
      return ans;
    }

  public static void main(String[] args){
    //test merge
    int[] M = {0,1,3,5};
    int[] N = {2,3,7,6,8,9};
    Merge.mergeSort(N);
    //int ans[] = Merge.merge(M,N);
    System.out.println(Arrays.toString(N));
  }


  }
