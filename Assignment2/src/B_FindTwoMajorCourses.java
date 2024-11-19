import java.util.Scanner;

public class B_FindTwoMajorCourses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int classes = input.nextInt();
        int[] scores = new int[classes];
        int[] credits = new int[classes];
        double[] grade_point = new double[classes];

        for (int i = 0; i < classes; i++){
            scores[i] = input.nextInt();
        }
        for (int i = 0; i < classes; i++){
            credits[i] = input.nextInt();
        }

        for (int i = 0; i < classes; i++){
            if (scores[i] >= 90)
                grade_point[i] = 4.0;
            else if (scores[i] >= 80)
                grade_point[i] = 3.0;
            else if (scores[i] >= 70)
                grade_point[i] = 2.0;
            else if (scores[i] >= 60)
                grade_point[i] = 1.0;
            else
                grade_point[i] = 0.0;
            }

        double gpa = input.nextDouble();
        for (int i = 0; i < classes; i ++){
            for (int j = i + 1; j < classes; j ++){
                double GPA = (grade_point[i] * credits[i] + grade_point[j] * credits[j]) / (credits[i] + credits[j]);
                if(Math.abs(gpa - GPA)<0.01)
                    System.out.printf("%d %d\n", i, j);
            }
        }
    }
}
