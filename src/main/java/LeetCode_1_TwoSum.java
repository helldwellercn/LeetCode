import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_TwoSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 最简单的暴力解法，效率较低
     * @param nums 整数数组
     * @param target 目标值
     * @return 数组下标
     */
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

    /**
     * hash法
     * 这种方法有两个形式，一种是循环两次，第一次把数字和下标存到 map 里，第二次去找元素的对应目标，目标不能是元素本身
     * 第二种只需要循环一次，一边存 map，一边找目标，原理和循环两次的方法一样。
     *
     * @param nums
     * @param target
     */
    public static int[] twoSumUseHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            if (map.get(d) != null && i != map.get(d)) { // 也可以用map.containsKey(d)
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
