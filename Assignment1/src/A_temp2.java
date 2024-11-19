import java.util.Scanner;

public class A_temp2 {
    public static void main(String[] args) {
        float tem1, tem2, tem3, max_tem, min_tem, average;
        float num = 2.0F;
        Scanner input = new Scanner(System.in);
        tem1 = input.nextFloat();
        tem2 = input.nextFloat();
        tem3 = input.nextFloat();

        max_tem = Math.max(Math.max(tem1, tem2), tem3);
        min_tem = Math.min(Math.min(tem1, tem2), tem3);

        average = (max_tem  + min_tem) / num;

        System.out.printf("%.2f", average);
    }
}
