public class LeetCode_9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(2133333314));
    }

    /**
     * 判断给定的x是否为回文数
     * @param x int型参数
     * @return true/false
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false; // x为负数或者x为10的整数倍
        }
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return x == y || x == y / 10;
    }
}
