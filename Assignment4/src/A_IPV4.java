import java.util.Scanner;

public class A_IPV4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();

        if (validIPV4(s))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    public static boolean validIPV4(String s){
        String[] numbers = s.split("\\.");
        if (numbers.length != 4) {
            return false;
        }

        // 逐个检查每个部分
        for (String part : numbers) {
            if (part.isEmpty()) {
                return false;
            }
            if (part.charAt(0) == '0')
                return false;
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
}
