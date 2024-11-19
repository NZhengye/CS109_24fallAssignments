import java.util.Scanner;

public class A_RotationArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();

        int[][] matrix1 = new int[rows][cols];
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j ++){
                matrix1[i][j] = input.nextInt();
            }
        }

        int[][] matrix2 = new int[cols][rows];
        for (int i = rows - 1, n = 0 ; i >= 0; i --, n ++) {
            for (int j = 0, m = 0; j < cols; j ++, m ++){
                matrix2[m][n] = matrix1[i][j];
            }
        }

        for (int i = 0; i < cols; i ++){
            for (int j = 0; j < rows; j ++){
                System.out.printf("%d ", matrix2[i][j]);
            }
            System.out.println();
        }
    }
}
