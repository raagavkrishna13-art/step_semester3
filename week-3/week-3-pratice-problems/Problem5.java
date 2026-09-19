import java.util.Arrays;

public class Problem5 {
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        // Reduce k to eliminate full array rotations
        k = k % n;

        int[] rotated = new int[n];

        // Place each element at its calculated new index
        for (int i = 0; i < n; i++) {
            int newPosition = (i + k) % n;
            rotated[newPosition] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        int[] rotated1 = rotateArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
        System.out.println(Arrays.toString(rotated1));

        int[] rotated2 = rotateArray(new int[] { 1, 2 }, 3);
        System.out.println(Arrays.toString(rotated2));
    }
}