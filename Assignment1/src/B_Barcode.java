import java.util.Scanner;

public class B_Barcode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        float barcode = 0.0f;
        int digits_number = input.nextInt();

        for (int i = 0; i <= 5; i++){
             sum += digits_number % 10;
             digits_number /= 10;
        }

        barcode = sum / 11.0f;
        System.out.printf("%.2f", barcode);

        input.close();
    }
}
