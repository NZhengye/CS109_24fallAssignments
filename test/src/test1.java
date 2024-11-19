public class test1 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5}};

        triple(arr[0], 2);
        triple(arr[1], 1);

        for (int i = 0; i < arr.length; i ++){
            for (int j = 0; j < arr[i].length; j ++){
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void triple(int[] x, int i) {
        x[i] = x[i - 1] * 3;
    }
}


