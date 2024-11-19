import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class A_temperature {
    public static void main(String[] args) {
        float tem1, tem2, tem3, max_tem, min_tem, average;
        Scanner input = new Scanner(System.in);
        tem1 = input.nextFloat();
        tem2 = input.nextFloat();
        tem3 = input.nextFloat();

        max_tem = Math.max(Math.max(tem1, tem2), tem3);
        min_tem = Math.min(Math.min(tem1, tem2), tem3);

        average = max_tem / 2.0f + min_tem / 2.0f;

        BigDecimal result = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP);

        System.out.printf("%.2f", result);
    }
}
