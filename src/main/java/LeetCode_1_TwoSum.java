import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSumUseHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            if (map.get(d) != null && i != map.get(d)) {
                return new int[]{map.get(d), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int[] result = twoSum(nums, 6);
        int[] resultUseHash = twoSumUseHash(nums, 6);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(resultUseHash));
    }
}
