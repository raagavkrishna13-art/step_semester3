public class Solution {
 public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] > nums[right]) {
            // Min must be in right unsorted half
            left = mid + 1;
        } else {
            // Min is at mid or in left sorted half
            right = mid;
        }
    }
    
    return nums[left];
}
}
