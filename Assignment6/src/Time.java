public class Time implements Comparable<Time>{
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int compareTo(Time other) {
        if (this.hour < other.hour) {return -1;}
        else if (this.hour > other.hour) {return 1;}

        if (this.minute < other.minute) {return -1;}
        else if (this.minute > other.minute) {return 1;}

        return 0;
    }

    public int timeInMinutes() {
        return hour * 60 + minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
