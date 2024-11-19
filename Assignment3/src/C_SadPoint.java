import java.util.Scanner;

public class C_SadPoint {
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

        boolean occurrence = false;
        int row_pos = -1, col_pos = -1;

        for (int i = 0; i < rows; i ++){
            int min = matrix[i][0];
            int min_col = 0;

            //遍历该行元素并找到最小值及其索引
            for (int j = 1; j < cols; j ++){
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                    min_col = j;
                }
            }

            //检查是否满足该列最大的条件
            boolean isMaxInCol = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][min_col] > min) {
                    isMaxInCol = false;
                    break;
                }
            }

            // 记录位置并终止循环
            if (isMaxInCol) {
                occurrence = true;
                row_pos = i;
                col_pos = min_col;
                break;
            }
        }

        if(occurrence){
            System.out.printf("%d %d %d", row_pos, col_pos, matrix[row_pos][col_pos]);
        }else{
            System.out.print("No Sad Point found");
        }
    }
}
