import java.util.*;

public class Driver{
  public static String print(int[] M){
    Stirng ans = "";
    for(int i = 0; i < M.length; i++){
      ans += M[i] + " ";
    }
    return ans;
  }
  //test merge
  int[] M = {0,1,3,5};
  int[] N = {2,3,6,7,8,9};

  System.out.print(print(Merge.merge(M,N)));
}
