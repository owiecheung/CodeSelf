package vtxlab.app.course3;








public class BinarySearch {
  
  public static Integer searchTarget(int[] nums, int target){

    int low = 0;
    int high = nums.length -1;
    while(low <= high){
      int mid = (high + low) /2 ;
      if(mid == target){
        return mid;
      }
      if(mid < target){

      }
    }
    return 0;
  }
}
