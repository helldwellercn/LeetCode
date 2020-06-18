public class LeetCode_13_Roman2Integer {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    /**
     * 罗马数字转整型
     * 罗马数字包含 I V X L C D M 这 7 种符号，分别对应 1 5 10 50 100 500 1000
     * I 可以放在 V 和 X 的左边，代表减一
     * X 可以放在 L 和 C 的左边，代表减十
     * C 可以放在 D 和 M 的左边，代表减一百
     * <p>
     * 循环字符串的每个字符，当前位置大于前一位就减去前一位，否则加上前一位，最后再加上整个字符串的最后一位
     *
     * @param s 罗马数字字符串
     */
    public static int romanToInt(String s) {
        int pre = getValue(s.charAt(0));
        int r = 0;
        if (s.length() == 1) {
            return pre;
        }
        for (int i = 1; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            if (pre < current) {
                r -= pre;
            } else {
                r += pre;
            }
            pre = current;
        }
        r += pre;
        return r;
    }

    /**
     * 另外一种解法
     * 思路是倒序遍历字符串
     * 当遇到 I X C 的时候判断当前总和是否大于当前字符对应值的5倍，如果小于就用加法，否则用减法
     * 相当简洁明了的思路
     *
     * @param s 罗马数字字符串
     */
    public static int romanToIntAlt(String s) {
        if (s.length() <= 0)
            return 0;
        char[] charArr = s.toUpperCase().toCharArray();
        int result = 0;
        for (int i = charArr.length - 1; i >= 0; i--) {
            switch (charArr[i]) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    result = result + 100 * (result >= 500 ? -1 : 1);
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    result = result + 10 * (result >= 50 ? -1 : 1);
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    result = result + (result >= 5 ? -1 : 1);
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
