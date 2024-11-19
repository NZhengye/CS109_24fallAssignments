import java.util.Scanner;

public class A_EmptyArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, operations = 0;
        n = input.nextInt();
        int[] array= new int[n];
        for (int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        while(array.length != 0) {
            if (array[0] == findMin(array)) {
                array = removeFirstElement(array);
            } else {
                array = rerangeArray(array);
            }
            operations++;
        }
        System.out.print(operations);
    }

    public static int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int[] removeFirstElement(int[] array) {
        int[] newArray = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }
        return newArray;
    }

    public static int[] rerangeArray(int[] array) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array[array.length - 1] = temp;
        return array;
    }
}
