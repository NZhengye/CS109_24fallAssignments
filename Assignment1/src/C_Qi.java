import java.util.Scanner;

public class C_Qi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total_day1 = 0, total_day2 = 0;
        int[] days_of_month = {51, 51, 52, 51, 51};

        int year1 = input.nextInt();
        int month1 = input.nextInt();
        int day1 = input.nextInt();
        int year2 = input.nextInt();
        int month2 = input.nextInt();
        int day2 = input.nextInt();

        for (int i = 0; i < month1 - 1;i ++){
            total_day1 += days_of_month[i];
            if (((year1 + i + 1) % 7) == 0){
                total_day1 ++;
            }
        }
        total_day1 += day1;

        for (int i = 0; i < month2 - 1;i ++){
            total_day2 += days_of_month[i];
            if (((year2 + i + 1) % 7) == 0){
                total_day2 ++;
            }
        }
        total_day2 += day2;

        int difference = total_day2 - total_day1;

        System.out.printf("%d", difference);

    }
}
