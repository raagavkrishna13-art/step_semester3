public class ProductExceptSelf {
 public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    
    // Pass 1: Accumulate left running products
    answer[0] = 1;
    for (int i = 1; i < n; i++) {
        answer[i] = answer[i - 1] * nums[i - 1];
    }
    
    // Pass 2: Accumulate right running products into answer
    int rightProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
        answer[i] = answer[i] * rightProduct;
        rightProduct *= nums[i];
    }
    
    return answer;
}

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = pes.productExceptSelf(nums);
        
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}