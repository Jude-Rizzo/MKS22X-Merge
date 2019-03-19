import java.util.*;

public class Driver{
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
  //System.out.println(Arrays.toString(N));
}

}
