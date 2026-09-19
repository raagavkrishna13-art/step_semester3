import java.util.HashMap;

public class Subarraysum{
 public int subarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> prefixMap = new HashMap<>();
    // Base case: prefix sum of 0 appears once (empty prefix)
    prefixMap.put(0, 1);
    
    int currentSum = 0;
    int count = 0;
    
    for (int num : nums) {
        currentSum += num;
        
        // If (currentSum - k) exists in map, add its frequency to count
        if (prefixMap.containsKey(currentSum - k)) {
            count += prefixMap.get(currentSum - k);
        }
        
        // Record current prefix sum count
        prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
    }
    
    return count;
}
}