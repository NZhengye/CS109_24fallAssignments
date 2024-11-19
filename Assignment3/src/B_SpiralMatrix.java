import java.util.Scanner;

public class B_SpiralMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j ++){
                matrix[i][j] = input.nextInt();
            }
        }

        int row_pos = 0, col_pos = 0;
        int row_num = rows, col_num = cols;

        while(true) {
            //向下
            if (row_num * col_num == 0)
                break;
            godown(matrix, row_pos, col_pos, row_num);
            row_pos += (row_num - 1);
            col_pos ++;
            col_num --;

            //向右
            if (row_num * col_num == 0)
                break;
            goright(matrix, row_pos, col_pos, col_num);
            row_pos --;
            col_pos += (col_num - 1);
            row_num --;

            //向上
            if (row_num * col_num == 0)
                break;
            goup(matrix, row_pos, col_pos, row_num);
            row_pos -= (row_num - 1);
            col_pos --;
            col_num --;

            //向左
            if (row_num * col_num == 0)
                break;
            goleft(matrix, row_pos, col_pos, col_num);
            row_pos ++;
            col_pos -= (col_num - 1);
            row_num --;
        }


    }

    public static void godown(int[][]matrix, int row_pos, int col_pos, int num){
        for (int i = row_pos; i < row_pos + num; i ++){
            System.out.printf("%d ", matrix[i][col_pos]);
        }
    }

    public static void goright(int[][]matrix, int row_pos, int col_pos, int num){
        for (int i = col_pos; i < col_pos + num; i ++){
            System.out.printf("%d ", matrix[row_pos][i]);
        }
    }

    public static void goup(int[][]matrix, int row_pos, int col_pos, int num){
        for (int i = row_pos; i > row_pos - num; i --){
            System.out.printf("%d ", matrix[i][col_pos]);
        }
    }

    public static void goleft(int[][]matrix, int row_pos, int col_pos, int num){
        for (int i = col_pos; i > col_pos - num; i --){
            System.out.printf("%d ", matrix[row_pos][i]);
        }
    }
}
