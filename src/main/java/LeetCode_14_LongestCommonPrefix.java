public class LeetCode_14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 最长公共前缀
     * <p>
     * 输入一组字符串，返回最长的公共前缀
     *
     * 1. 先假定最大公共前缀就是第一个字符串，设为 r
     * 2. 从数组第二个字符串开始，遍历数组 strs
     * 3. 循环比较当前数组元素和 r 的字符，并记录相同字符的长度 j，当不相同时结束循环
     * 4. 此时 r 的前 j 位就是新的公共前缀，将新的公共前缀设为 r，重复直到数组遍历结束。
     *
     * @param strs 字符串数组
     * @return 前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        // 处理空数组
        if (strs.length == 0) {
            return "";
        }
        String r = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < r.length() && j < strs[i].length(); j++) { // 要处理第一个字符串是空串的情况
                if (strs[i].charAt(j) != r.charAt(j)) {
                    break;
                }
            }
            r = r.substring(0, j);
            if ("".equals(r)) {
                return r;
            }
        }
        return r;
    }
}
