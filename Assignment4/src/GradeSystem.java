public class GradeSystem {
    public static void generateStudentGroupSize(Student[] students){
        for (int i = 0; i < students.length; i++) {
            Student currentStudent = students[i];
            char groupNumber = currentStudent.getGroupNumber();
            int count = 0;

            for (int j = 0; j < students.length; j++) {
                if (students[j].getGroupNumber() == groupNumber) {
                    count++;
                }
            }

            currentStudent.setGroupSize(count);
        }
    }

    public static void standardizedScores(Student[] students){
        for (int i = 0; i < students.length; i++) {
            Student currentStudent = students[i];
            char groupNumber = currentStudent.getGroupNumber();
            int groupScore = currentStudent.getGroupScore();

            for (int j = 0; j < students.length; j++) {
                if (students[j].getGroupNumber() == groupNumber) {
                    if (students[j].getGroupScore() != groupScore){
                        students[i].setGroupScore(60);
                        students[j].setGroupScore(60);
                    }
                }
            }

        }
    }

    public static void generatePersonalScore(Student[] students){
        for (Student student : students) {
            double personalScore = Student.calculatePersonalScore(
                    student.getGroupScore(),
                    student.getRate(),
                    student.getGroupSize()
            );

            student.updatePersonalScore();
        }

    }
}
