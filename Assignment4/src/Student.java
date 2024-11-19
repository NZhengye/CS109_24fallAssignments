public class Student {
    private static int count = 0;
    public static double calculatePersonalScore(int groupScore, int rate, int
            groupSize){
        double percentage = 0.;
        if (groupSize == 2){
            if (rate >=0 && rate <= 5){
                percentage = 20 / 100.;
                return groupScore * percentage;}
            if (rate >5 && rate <= 10){
                percentage = (20 + 4 * (rate - 5)) / 100.;
                return groupScore * percentage;}
            if (rate >10 && rate <= 30){
                percentage = (40 + 2 * (rate - 10)) / 100.;
                return groupScore * percentage;}
            if (rate >30 && rate <= 50){
                percentage = (80 + 1 * (rate - 30)) / 100.;
                return groupScore * percentage;}
            if (rate >50 && rate <= 90){
                percentage = (100 + 0.625 * (rate - 50)) / 100.;
                return groupScore * percentage;}
            if (rate >90 && rate <= 100){
                percentage = 125 / 100.;
                return groupScore * percentage;}
        }
        if (groupSize == 3){
            if (rate >=0 && rate <= 5){
                percentage = 15 / 100.;
                return groupScore * percentage;}
            if (rate >5 && rate <= 18){
                percentage = (15 + 5 * (rate - 5)) / 100.;
                return groupScore * percentage;}
            if (rate >18 && rate <= 33){
                percentage = (80 + 4 / 3. * (rate - 18)) / 100.;
                return groupScore * percentage;}
            if (rate >33 && rate <= 75){
                percentage = (100 + 11 / 21. * (rate - 33)) / 100.;
                return groupScore * percentage;}
            if (rate >90 && rate <= 100){
                percentage = 122 / 100.;
                return groupScore * percentage;}
        }
        return 0.;
    }

    private int studentId;
    private int groupSize;
    private char groupNumber;
    private int groupScore;
    private double personalScore;
    private int rate; //the contribute rate of current student

    public Student(int groupScore, int rate, char groupNumber){
        this.groupScore = groupScore;
        this.rate = rate;
        this.groupNumber = groupNumber;
        this.studentId = ++count;
    }

    public Student(int groupScore, int rate, int groupSize){
        this.groupScore = groupScore;
        this.rate = rate;
        this.groupSize = groupSize;
        this.studentId = ++count;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getGroupScore() { return groupScore; }
    public void setGroupScore(int groupScore) { this.groupScore = groupScore; }

    public int getRate() { return rate; }
    public void setRate(int rate) { this.rate = rate; }

    public char getGroupNumber() { return groupNumber; }
    public void setGroupNumber(char groupNumber) { this.groupNumber = groupNumber; }

    public int getGroupSize() { return groupSize; }
    public void setGroupSize(int groupSize) { this.groupSize = groupSize; }

    public int getPersonalScore() { return (int)Math.round(personalScore); }

    public void updatePersonalScore() {
        this.personalScore = calculatePersonalScore(groupScore, rate, groupSize);
    }

    @Override
    public String toString() {
        return studentId + " group:" + groupScore + " personal:" + (int)Math.round(personalScore) + " rate:" + rate;
    }
}
