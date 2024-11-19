//need optimization
import java.util.Scanner;

public class A_try1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();

        if (validIPV4(s))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
    public static boolean validIPV4(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        // 分割字符串，用“.”作为分隔符
        String[] parts = s.split("\\.");

        // IPv4地址必须包含4部分
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            // 检查每部分是否是数字
            if (!part.matches("\\d+")) {
                return false;
            }

            try {
                int num = Integer.parseInt(part);
                // 检查数字是否在0到255之间
                if (num < 0 || num > 255) {
                    return false;
                }
                // 检查前导零
                if (part.length() > 1 && part.startsWith("0")) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

}
