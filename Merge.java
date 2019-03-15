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
      } else {
        ans[n + m] = M[m];
        m++;
        mRemaining--;
      }
    }

    //Now we still have the rest of the maximum array leftOver
    //find the maximum array, lets call it bigger
    //atleast one of these will be 0
    int bi = Math.max(mRemaining, nRemaining);
    if(bi == mRemaining){
      //if m remaining has stuff left, add it to the end of the answer
      for(int i = m; i < M.length; i++ ){
        ans[i] = M[i];
      }
    } else {
      for(int i = n; i < N.length; n++){
        ans[i] = N[i];
      }
    }

    return ans;
    //Take the rest of the bigger array and just add it to the end of the answer array


    }

  }
