import java.util.Scanner;
//神tm要double才能用

public class A_temp3 {
    public static void main(String[] args) {
        double tem1, tem2, tem3, max_tem, min_tem, average;
        double num = 2.0;
        Scanner input = new Scanner(System.in);
        tem1 = input.nextDouble();
        tem2 = input.nextDouble();
        tem3 = input.nextDouble();

        max_tem = Math.max(Math.max(tem1, tem2), tem3);
        min_tem = Math.min(Math.min(tem1, tem2), tem3);

        average = (max_tem  + min_tem) / num;

        System.out.printf("%.2f", average);
    }
}
