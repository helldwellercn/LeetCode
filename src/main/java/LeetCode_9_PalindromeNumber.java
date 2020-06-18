public class LeetCode_9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(2133333314));
    }

    /**
     * 判断给定的 x 是否为回文数
     *
     * 回文数是对称的，所以 x 翻转之后还是 x
     *
     * 用一个新的变量 y 去存储翻转中的 x，同时每次翻转都去掉 x 的最后一位，这样就可以设定一个条件：当 x <= y 的时候中断翻转来提高效率
     *
     * 当 x 长度为奇数的时候，需要把翻转得出的 y 的最后一位去掉。
     *
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
