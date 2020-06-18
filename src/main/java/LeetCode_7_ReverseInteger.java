public class LeetCode_7_ReverseInteger {
    /**
     * 通过循环获取x的最后一位，且每次循环都会去掉x的最后一位（x=x/10）
     * 同时每次都用x的最后一位乘10，最终实现翻转的效果
     *
     * @param x int型参数
     * @return 翻转后的值，若超出int范围则返回0
     */
    public static int reverse(int x) {
        long y = 0; // 用long类型防止翻转后溢出
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return (int) y == y ? (int) y : 0; // 判断是否溢出，如果溢出则返回0
    }

    public static void main(String[] args) {
        int reverse = reverse(123123123);
        System.out.println(reverse);
    }
}
