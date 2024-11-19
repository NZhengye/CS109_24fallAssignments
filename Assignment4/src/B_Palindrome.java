import java.util.Scanner;

public class B_Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s_raw = input.nextLine();
        String s_move = input.nextLine();

        if (isPalindrome(s_raw, s_move))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    public static boolean isPalindrome(String s_raw, String s_move){
        s_raw = s_raw.replace(s_move, "");
        s_raw = s_raw.replaceAll("[^a-zA-Z]", "");
        s_raw = s_raw.toLowerCase();

        if (s_raw.isEmpty()) {
            return true;
        }

        for (int i = 0; i < s_raw.length() / 2; i++) {
            if (s_raw.charAt(i) != s_raw.charAt(s_raw.length() - 1 - i))
                return false;
        }
        return true;
    }
}
