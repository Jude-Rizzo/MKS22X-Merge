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



    public static void mergeSort(int[] list){
      int[] list1 =  mergeH(0,list.length - 1, list);
      for(int i = 0; i < list1.length; i++){
        list[i] = list1[i];
      }



    }


    public static void test(int t){
      t = 1;

    }


    public static int[] mergeH(int lo, int hi, int[] list){
    //  System.out.println("lo: " + lo);
      //System.out.println("hi: " + hi);
      //ok, we want to split up the list into much smaller lists
      //we can start off by saying that if the list has length 1 or lo = hi, were gonna
      //return a list with only that element

      if(lo == hi){
        int[] ans = new int[1];
        ans[0] = list[lo];
        return ans;
      }
      //now we can mergeH the smaller cases
    /*  if(lo > hi - 20){
        int[] h1 = insertionSort(list, lo, hi);
        int[] h2 = new int[hi - lo];
        for(int i = lo; i < hi; i++){
          h2[i - lo] = h1[i];
        }
        return h2;
      } else {*/
      int[] h1 = mergeH(lo, (lo + hi)/2, list);
      int[] h2 = mergeH((lo + hi)/2 + 1, hi, list);
      return merge(h1, h2);

      //System.out.println(Arrays.toString(merge(h1, h2)));



    }





    public static int[] insertionSort(int[] ary, int lo, int hi){
      for(int i = lo + 1; i <= hi; i++){
        int orig = ary[i];
        int cur = i;
        while(cur != 0 && ary[cur-1] > orig){
          ary[cur] = ary[cur - 1]; //shift
          cur --;
        }
        ary[cur] = orig;
      }
      //System.out.prinln(ary);
      return ary;
    }

  public static void main(String[] args){
    //test merge
    int[] M = {5,1,3,0,3,2,1};
    int[] N = {2,1};
    Merge.mergeSort(N);
    //int ans[] = Merge.merge(M,N);
    mergeSort(M);
    //System.out.println(Arrays.toString(M));
    int m = 3;
    test(m);
    System.out.println(m);
  }


  }
